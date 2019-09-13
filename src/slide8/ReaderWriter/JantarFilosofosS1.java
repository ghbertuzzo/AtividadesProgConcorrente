/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Solução 1 para o Jantar dos Filósofos
 */

package slide8.ReaderWriter;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class JantarFilosofosS1 {

    int numberResources = 0;
    Semaphore[] fork = null;
    FilosofosS1[] listFil = null;

    public static void main(String[] args) {
        JantarFilosofosS1 jf = new JantarFilosofosS1(5);
    }

    public JantarFilosofosS1(int initResources) {
        this.numberResources = initResources;
        fork = new Semaphore[initResources];
        for (int i = 0; i < initResources; i++) {
            fork[i] = new Semaphore(1);
        }
        listFil = new FilosofosS1[initResources];
        for (int i = 0; i < initResources; i++) {
            listFil[i] = new FilosofosS1(i, this);
            listFil[i].start();
        }
    }

    public void eating(int idFilosofo) {
        System.out.println("Filosofo " + idFilosofo + " comendo.");
    }

    public void thinking(int idFilosofo) throws InterruptedException {
        System.out.println("Filosofo " + idFilosofo + " pensando.");
        Integer rand = new Random().nextInt(100);
        sleep(rand);
    }

    public void take(int idFilosofo) throws InterruptedException {
        fork[idFilosofo].acquire();
        System.out.println("Filosofo " + idFilosofo + " pegou primeiro garfo.");
        fork[(idFilosofo + 1) % this.numberResources].acquire();
        System.out.println("Filosofo " + idFilosofo + " pegou segundo garfo.");
    }

    public void release(int idFilosofo) {
        fork[idFilosofo].release();
        fork[(idFilosofo + 1) % this.numberResources].release();
        System.out.println("Filosofo " + idFilosofo + " liberou garfos.");
    }

}
