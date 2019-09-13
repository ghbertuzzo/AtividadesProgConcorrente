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

public class Leitor extends Thread {

    ArrayListThreadSafe alts;

    public Leitor(ArrayListThreadSafe alts) {
        this.alts = alts;
    }

    @Override
    public void run() {
        while (true) {
            String content = alts.ler();
            System.out.println("Leitor" + Thread.currentThread().getName() + ": " + content);
            Random rand = new Random();
            int valor = rand.nextInt(10);
            try {
                sleep(valor * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Leitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
