/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide8.ReaderWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
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
        while (cont!=10) {
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
