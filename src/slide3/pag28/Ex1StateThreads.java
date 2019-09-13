/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Faça um programa em Java que consulte periodicamente o
    estado de um conjunto de threads.
 */

package slide3.pag28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1StateThreads {

    public static void main(String[] args) throws InterruptedException {

        ThreadX thread = new ThreadX();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        new Thread(() -> {

        }).start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }

    private static class ThreadX extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex1StateThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
