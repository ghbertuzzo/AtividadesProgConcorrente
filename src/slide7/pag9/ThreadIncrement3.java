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
public class ThreadIncrement3 extends Thread {
    
    Ex5Barreira ex5;
    boolean locked;
    
    public ThreadIncrement3(Ex5Barreira ex, boolean lock){
        this.ex5 = ex;
        this.locked = lock;
    }
    
    @Override
    public void run() {
        while (true) {            
            if(this.locked){
                System.out.println("System exit. Thread"+Thread.currentThread().getId());
                break;
            }else{
                try {
                    ex5.increment();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadIncrement3.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadIncrement3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
        System.out.println("Matando Thread.");
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
