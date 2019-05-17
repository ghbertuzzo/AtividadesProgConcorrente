/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7.pag9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class ThreadTrecho extends Thread {

    Ex2Rendezvous ex02;
    String name;
    int trecho;
    
    public ThreadTrecho(Ex2Rendezvous ex, String name) {
        this.ex02 = ex;
        this.name = name;
        this.trecho = 0;
    }
    
    @Override
    public void run() {
        while (true) {
            if(trecho>=2){
                trecho = 1;
            }else{
                trecho += 1;
            }
            try {
                ex02.trecho("Trecho"+this.name+"."+this.trecho);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTrecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadTrecho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
