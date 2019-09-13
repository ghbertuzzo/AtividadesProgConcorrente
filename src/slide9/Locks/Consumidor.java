/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Crie uma classe SharedFifoQueue e use Conditions para
    controlar se a fila está vazia ou cheia. Teste usando threads
    produtoras e consumidoras.
 */

package slide9.Locks;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    SharedFifoQueue sfq;

    public Consumidor(SharedFifoQueue sfq) {
        this.sfq = sfq;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.sfq.getValorLista();
            System.out.println("Consumido: " + valor);
            Random rand = new Random();
            valor = rand.nextInt(10);
            try {
                sleep(valor);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
