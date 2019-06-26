/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
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
        int value=-999;
        this.lock.lock();        
        try {
            while(this.list.size() <= 0){
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
            while (this.list.size()>=this.size) {
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
