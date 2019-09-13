/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSleeper extends Thread {

    Ex2ThreadCountSleep exs;

    public ThreadSleeper(Ex2ThreadCountSleep ex) {
        this.exs = ex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.exs.dormir();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSleeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
