/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.concurrent.Semaphore;

public class Ex5Barreira {

    Semaphore semaforo;
    Semaphore mutex;
    int barreira;
    int countThreads;
    int nThreads;
    boolean locked;

    public Ex5Barreira(int nThreads, int barreira) {
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
        System.out.println("Value: " + this.countThreads);
        if (this.countThreads >= barreira) {
            System.out.println("liberando " + this.countThreads + " Threads em espera.");
            this.locked = true;
            this.countThreads = 0;
            this.semaforo.release();
        }
        this.mutex.release();
        this.semaforo.acquire();
    }

    public void stort() {
        for (int i = 0; i < this.nThreads; i++) {
            ThreadIncrement3 thread = new ThreadIncrement3(this, this.locked);
            thread.start();
        }
    }
}
