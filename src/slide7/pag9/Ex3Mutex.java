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
public class Ex3Mutex {
    
    Semaphore semaforo;
    ThreadIncrement thread1;
    ThreadIncrement thread2;
    ThreadIncrement thread3;
    ThreadIncrement thread4;
    int count;
    
    public Ex3Mutex() {
        this.semaforo = new Semaphore(1);
        this.thread1 = new ThreadIncrement(this);
        this.thread2 = new ThreadIncrement(this);
        this.thread3 = new ThreadIncrement(this);
        this.thread4 = new ThreadIncrement(this);
        this.count = 0;
    }

    void increment() throws InterruptedException {
        this.semaforo.acquire();
        this.count++;
        System.out.println("Value: "+this.count);
        this.semaforo.release();
    }
    
    public void stort(){
        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
        this.thread4.start();
    }
    
}
