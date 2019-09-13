/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor extends Thread {

    Ex1CircularProducerConsumer mymonitor;

    public Produtor(Ex1CircularProducerConsumer myclass) {
        this.mymonitor = myclass;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.mymonitor.produce();
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
