/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadObserver extends Thread {

    Ex3BoundedCounter ex;
    int time;
    int min;
    int max;

    public ThreadObserver(Ex3BoundedCounter ex, int time, int min, int max) {
        this.ex = ex;
        this.time = time;
        this.min = min;
        this.max = max;
    }

    @Override
    public synchronized void run() {
        while (true) {
            if (ex.boundedCounter > max) {
                System.out.println("Atingiu limite máximo!");
                ex.interruptIncrement();
            } else if (ex.boundedCounter < min) {
                System.out.println("Atingiu limite minimo!");
                ex.interruptDecrement();
            } else {
                System.out.println("Bounded Value: " + this.ex.boundedCounter);
            }
            try {
                sleep(this.time);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
