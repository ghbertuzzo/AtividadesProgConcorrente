/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.concurrent.Semaphore;

public class Ex4Multiplex {

    Semaphore semaforo;
    int count;
    int nThreads;

    public Ex4Multiplex(int nThreads) {
        this.semaforo = new Semaphore(nThreads);
        this.nThreads = nThreads;
        this.count = 0;
    }

    synchronized void increment() throws InterruptedException {
        this.semaforo.acquire();
        this.count++;
        System.out.println("Value: " + this.count);
        this.semaforo.release();
    }

    public void stort() {
        for (int i = 0; i < this.nThreads; i++) {
            ThreadIncrement2 thread = new ThreadIncrement2(this);
            thread.start();
        }
    }

}
