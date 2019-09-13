/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import java.util.Random;

public class Ex1CircularProducerConsumer {

    int[] buffer;
    int readpos;
    int writepos;
    int tam;
    int sizelements;
    Object monitor;

    public Ex1CircularProducerConsumer(int tam) {
        this.buffer = new int[tam];
        this.readpos = 0;
        this.writepos = 0;
        this.tam = tam;
        this.sizelements = 0;
        monitor = new Object();
    }

    public void stort() {
        Consumidor consumidor = new Consumidor(this);
        Produtor produtor = new Produtor(this);
        consumidor.start();
        produtor.start();
    }

    public synchronized void consume() throws InterruptedException {
        while (this.sizelements == 0) {
            this.wait();
            System.out.println("Buffer Vazio!");
        }
        int nextSlot = this.writepos - this.tam;
        if (nextSlot < 0) {
            nextSlot += this.tam;
        }
        int retorno = this.buffer[nextSlot];
        this.sizelements--;
        System.out.println("Consumido " + retorno + "pos " + nextSlot);
        this.notifyAll();

    }

    public synchronized void produce() throws InterruptedException {
        while (this.sizelements == this.tam) {
            wait();
            System.out.println("Buffer Cheio!");
        }
        if (this.sizelements < this.tam) {
            if (this.writepos >= this.tam) {
                this.writepos = 0;
            }
            Random rand = new Random();
            int n = rand.nextInt(5);
            this.buffer[this.writepos] = n;
            this.writepos++;
            this.sizelements++;
            System.out.println("Produzido " + n + " pos " + (this.writepos - 1));
            notify();
        }
    }

}
