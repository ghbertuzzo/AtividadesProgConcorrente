/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slideA10.Collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Consumidor extends Thread{
    
    ArrayBlockingQueue<String> array;
    
    public Consumidor(ArrayBlockingQueue<String> array){
        this.array = array;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("Thread "+Thread.currentThread().getName()+" Consumi: "+array.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
