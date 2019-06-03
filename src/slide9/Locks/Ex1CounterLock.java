/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author a1602020
 */
public class Ex1CounterLock {
    
    int counter;
    Lock lock;
    
    public Ex1CounterLock(){
        counter = 0;
        lock = new ReentrantLock();
    }
    
    public void increment (){
        lock.lock();
        try {
            counter++;        
            System.out.println("Valor Atual: "+counter);
        } finally {
            lock.unlock();
        }
    }
    
    public void decrement (){
        lock.lock();
        try {
            counter--;       
            System.out.println("Valor Atual: "+counter); 
        } finally {
            lock.unlock();
        }
    }
    
}
