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
public class ThreadDecrement extends Thread{
    
    Ex3BoundedCounter ex_03;
    int time;

    public ThreadDecrement(Ex3BoundedCounter ex, int time) {
        this.ex_03 = ex;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.ex_03.decrement();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDecrement.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(this.time);
            } catch (InterruptedException ex) {
                System.out.println("ThreadDecrement interrompida.");
                System.exit(0);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }

}
