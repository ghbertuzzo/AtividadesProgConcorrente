/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author giova
 */
public class ArrayListThreadSafe {
    
    String content;
    ReentrantReadWriteLock readWriteLock;

    public ArrayListThreadSafe() {
        this.content = "";
        this.readWriteLock = new ReentrantReadWriteLock();
    
    }
    
    public void escrever(String texto){
        this.readWriteLock.writeLock().lock();
        try {
            this.content += texto;
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    
    public String ler(){
        this.readWriteLock.readLock().lock();
        try {
            return this.content;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }
}
