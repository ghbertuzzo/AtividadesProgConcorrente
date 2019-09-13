/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */
package slide6a.Monitores;

import java.util.Random;

public class Ex3BoundedCounter {

    int min;
    int max;
    int boundedCounter;
    int tinc;
    int tdec;
    ThreadIncrement ti;
    ThreadDecrement td;
    ThreadObserver to;

    public Ex3BoundedCounter(int min, int max) {
        this.min = min;
        this.max = max;
        this.boundedCounter = (min + max) / 2;;
        Random rand = new Random();
        tinc = rand.nextInt(200);
        this.ti = new ThreadIncrement(this, tinc);
        tdec = rand.nextInt(200);
        this.td = new ThreadDecrement(this, tdec);
        this.to = new ThreadObserver(this, 10, min, max);
    }

    public synchronized void stort() {
        this.ti.start();
        this.td.start();
        this.to.start();
    }

    public synchronized void increment() throws InterruptedException {
        while (this.boundedCounter > this.max) {
            this.notify();
        }
        this.boundedCounter++;
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {
        while (this.boundedCounter < this.min) {
            this.notify();
        }
        this.boundedCounter--;
    }

    void interruptDecrement() {
        System.out.println("Increment Time: " + this.tinc);
        System.out.println("Decrement Time: " + this.tdec);
        this.td.interrupt();
    }

    void interruptIncrement() {
        System.out.println("Increment Time: " + this.tinc);
        System.out.println("Decrement Time: " + this.tdec);
        this.ti.interrupt();
    }
}
