/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    Ex1CircularProducerConsumer mymonitor;

    public Consumidor(Ex1CircularProducerConsumer myclass) {
        this.mymonitor = myclass;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.mymonitor.consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
