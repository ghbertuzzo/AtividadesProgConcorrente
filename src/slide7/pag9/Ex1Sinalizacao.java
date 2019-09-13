/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.concurrent.Semaphore;

public class Ex1Sinalizacao {

    Semaphore semaforo;
    ThreadSleeper thread1;
    ThreadSleeper thread2;

    public Ex1Sinalizacao() {
        this.semaforo = new Semaphore(1);
        this.thread1 = new ThreadSleeper(this, "T1");
        this.thread2 = new ThreadSleeper(this, "T2");
    }

    public synchronized void message(String message) throws InterruptedException {
        this.semaforo.acquire();
        System.out.println(message);
        this.semaforo.release();
    }

    public void stort() {
        this.thread1.start();
        this.thread2.start();
    }
}
