/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
    Teste usando threads que realizam leitura e escrita para essa
    estrutura.
 */

package slide9.Locks;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread {

    ArrayListThreadSafe alts;

    public Escritor(ArrayListThreadSafe alts) {
        this.alts = alts;
    }

    @Override
    public void run() {
        while (true) {
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'a');
            String s = Character.toString(c);
            this.alts.escrever(s);
            System.out.println("Escritor" + Thread.currentThread().getName() + ": " + c);
            Random rand = new Random();
            int valor = rand.nextInt(10);
            try {
                sleep(valor * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
