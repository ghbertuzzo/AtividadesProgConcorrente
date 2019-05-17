/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide6a.Monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class ThreadSleeper extends Thread{
    
    Ex2ThreadCountSleep exs;

    public ThreadSleeper(Ex2ThreadCountSleep ex) {
        this.exs = ex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.exs.dormir();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSleeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
