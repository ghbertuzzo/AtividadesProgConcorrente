/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Faça um programa em Java que inicie três threads e, cada
    thread, espere um tempo aleatório para terminar.
 */

package slide3.pag17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1ThreadSleepRandom extends Thread {

    @Override
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        int tempo = n * 1000;
        try {
            this.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex1ThreadSleepRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sou a Thread " + this.getId() + " e esperei por " + n + " segundos antes de morrer.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Ex1ThreadSleepRandom());
            t.start();
        }
    }

}
