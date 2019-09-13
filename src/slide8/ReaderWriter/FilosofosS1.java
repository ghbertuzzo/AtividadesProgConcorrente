/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Solução 1 para o Jantar dos Filósofos
 */

package slide8.ReaderWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FilosofosS1 extends Thread {

    JantarFilosofosS1 jf;
    int id;

    public FilosofosS1(int id, JantarFilosofosS1 jf) {
        this.id = id;
        this.jf = jf;
    }

    @Override
    public void run() {
        int cont = 0;
        while (cont != 10) {
            try {
                jf.thinking(this.id);
            } catch (InterruptedException ex) {
                Logger.getLogger(JantarFilosofosS1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                jf.take(this.id);
            } catch (InterruptedException ex) {
                Logger.getLogger(JantarFilosofosS1.class.getName()).log(Level.SEVERE, null, ex);
            }
            jf.eating(this.id);
            cont++;
            jf.release(this.id);
        }
    }

}
