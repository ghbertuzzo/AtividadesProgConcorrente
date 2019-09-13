/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSleeper extends Thread {

    Ex1Sinalizacao ex1;
    String name;

    public ThreadSleeper(Ex1Sinalizacao ex, String nome) {
        this.ex1 = ex;
        this.name = nome;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.ex1.message("Thread Sleeper : " + this.name);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSleeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSleeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
