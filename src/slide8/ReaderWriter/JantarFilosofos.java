package slide8.ReaderWriter;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class JantarFilosofos {

    int numberResources = 0;
    Semaphore[] fork = null;
    boolean[] forkLibert = null;
    Filosofo[] listFil = null;

    public static void main(String[] args) {
        JantarFilosofos jf = new JantarFilosofos(5);
        for (int i = 0; i < jf.listFil.length; i++) {
            jf.listFil[i].run();
        }

    }

    public JantarFilosofos(int initResources) {
        this.numberResources = initResources;
        fork = new Semaphore[initResources];
        for (int i = 0; i < initResources; i++) {
            fork[i] = new Semaphore(1);
        }
        forkLibert = new boolean[initResources];
        for (int i = 0; i < initResources; i++) {
            forkLibert[i] = true;
        }
        for (int i = 0; i < initResources; i++) {
            listFil[i] = new Filosofo(i, this);
        }
    }

    public synchronized void take(int idFilosofo) throws InterruptedException {
        if (forkLibert[idFilosofo] && forkLibert[(idFilosofo + 1) % this.numberResources]) {
            fork[idFilosofo].acquire();
            fork[(idFilosofo + 1) % this.numberResources].acquire();
            forkLibert[idFilosofo] = false;
            forkLibert[(idFilosofo + 1) % this.numberResources] = false;
        }
    }

    public synchronized void release(int idFilosofo) {
        forkLibert[idFilosofo] = true;
        forkLibert[(idFilosofo + 1) % this.numberResources] = true;
        fork[idFilosofo].release();
        fork[(idFilosofo + 1) % this.numberResources].release();
    }

    public class Filosofo implements Runnable {

        JantarFilosofos jf;
        int id;

        public Filosofo(int id, JantarFilosofos jf) {
            this.id = id;
            this.jf = jf;
        }

        @Override
        public void run() {
            int cont = 0;
            while (cont < 10) {
                try {
                    thinking(this.id);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JantarFilosofos.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    jf.take(this.id);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JantarFilosofos.class.getName()).log(Level.SEVERE, null, ex);
                }
                eating(this.id);
                cont++;
                jf.release(this.id);
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
    }

}