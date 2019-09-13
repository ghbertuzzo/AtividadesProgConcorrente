/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Crie uma classe SharedFifoQueue e use Conditions para
    controlar se a fila está vazia ou cheia. Teste usando threads
    produtoras e consumidoras.
 */

package slide9.Locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedFifoQueue {

    ArrayList<Integer> list;
    int size;
    Lock lock;
    Condition notFull;
    Condition notEmpty;

    public SharedFifoQueue(int size) {
        this.list = new ArrayList<>();
        this.size = size;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public int getValorLista() {
        int value = -999;
        this.lock.lock();
        try {
            while (this.list.size() <= 0) {
                System.out.println("Consumidor waiting");
                this.notEmpty.await();
            }
            value = this.list.get(0);
            this.list.remove(0);
            this.size--;
            this.notFull.signal();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedFifoQueue.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.lock.unlock();
        }
        return value;
    }

    public void setValorLista(int valor) {
        this.lock.lock();
        try {
            while (this.list.size() >= this.size) {
                System.out.println("Produtor waiting");
                this.notFull.await();
            }
            this.size++;
            this.list.add(valor);
            this.notEmpty.signal();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedFifoQueue.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.lock.unlock();
        }
    }

}
