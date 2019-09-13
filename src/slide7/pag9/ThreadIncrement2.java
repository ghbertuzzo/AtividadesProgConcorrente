/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadIncrement2 extends Thread {

    Ex4Multiplex ex4;

    public ThreadIncrement2(Ex4Multiplex ex) {
        this.ex4 = ex;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.ex4.increment();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadIncrement2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadIncrement2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
}
