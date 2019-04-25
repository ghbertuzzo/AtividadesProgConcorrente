/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag28;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex2GroupThread extends Thread{
    
    ThreadGroup threadGroup;
    
    public static void main(String[] args) throws InterruptedException {
        
        ThreadGroup tg = new ThreadGroup("Sleepers");
        Thread t1 = new Ex2GroupThread(tg,"Thread 1");
        Thread t2 = new Ex2GroupThread(tg,"Thread 2");
        Thread t3 = new Ex2GroupThread(tg,"Thread 3");
        Thread t4 = new Ex2GroupThread(tg,"Thread 4");
        Thread t5 = new Ex2GroupThread(tg,"Thread 5");
        Thread t6 = new Ex2GroupThread(tg,"Thread 6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t1.join();
        System.out.println("Ativas: "+tg.activeCount()); 
    }

    private Ex2GroupThread(ThreadGroup tg, String thread_2) {
        this.threadGroup = tg;
        this.setName(thread_2);
    }

    @Override
    public void run() {
        int i = 0;
        while(i<3){
            Random generate = new Random();
            int num = generate.nextInt(5);
            if(num>3){
                System.out.println(this.getName()+": I died;");
                return;
            }
            try {
                this.sleep(num * 1000);
                System.out.println(this.getName()+" say: the number threads active now is "+super.getThreadGroup().activeCount());
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex2GroupThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    
}
