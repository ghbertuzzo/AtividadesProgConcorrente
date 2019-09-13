/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadDecrement extends Thread {

    Ex3BoundedCounter ex_03;
    int time;

    public ThreadDecrement(Ex3BoundedCounter ex, int time) {
        this.ex_03 = ex;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.ex_03.decrement();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDecrement.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(this.time);
            } catch (InterruptedException ex) {
                System.out.println("ThreadDecrement interrompida.");
                System.exit(0);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }

}
