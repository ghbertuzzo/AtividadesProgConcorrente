/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7.pag9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giova
 */
public class Ex5Barreira {
    
    Semaphore semaforo;
    Semaphore mutex;
    int barreira;
    int countThreads;
    int nThreads;
    boolean locked;

    public Ex5Barreira(int nThreads,int barreira) {
        this.barreira = barreira;
        this.mutex = new Semaphore(1);
        this.semaforo = new Semaphore(nThreads);
        this.nThreads = nThreads;
        this.countThreads = 0;
        this.locked = false;
    }
    
    void increment() throws InterruptedException {
        this.mutex.acquire();
        this.countThreads++;
        System.out.println("Value: "+this.countThreads);
        if (this.countThreads >= barreira) {
            System.out.println("liberando "+this.countThreads+" Threads em espera.");
            this.locked = true;
            this.countThreads = 0;
            this.semaforo.release();
        }
        this.mutex.release();
        this.semaforo.acquire();
    }
    
    public void stort() {
        for (int i = 0; i < this.nThreads; i++) {
            ThreadIncrement3 thread = new ThreadIncrement3(this,this.locked);
            thread.start();
        }
    }
}
