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
public class ThreadIncrement extends Thread {
    
    Ex3Mutex ex3;
    
    public ThreadIncrement(Ex3Mutex ex){
        this.ex3 = ex;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                this.ex3.increment();
                System.out.println("Incremented by: Thread"+Thread.currentThread().getId());
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadIncrement.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadIncrement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
