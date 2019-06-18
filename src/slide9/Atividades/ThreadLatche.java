/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class ThreadLatche implements Runnable {
    
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    float [] vector;
    float [] copyVector;
    int position;
    
    public ThreadLatche(CountDownLatch start, CountDownLatch done,float [] vector, int position){
        this.startSignal = start;
        this.doneSignal = done;
        this.vector = vector;
        this.copyVector = new float[vector.length];
        copy();
        this.position = position;
    }

    @Override
    public void run() {
        //System.out.println("START THREAD "+Thread.currentThread().getId());
        try {
            startSignal.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLatche.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(position==0 || position==this.vector.length-1){
            this.vector[position] = this.copyVector[position];
        }else{
            this.vector[position] = (this.copyVector[position-1]+this.copyVector[position+1])/2;
        }    
        //System.out.println("END THREAD "+Thread.currentThread().getId());
        doneSignal.countDown();        
    }
    
    private void copy() {
        for(int i = 0;i<this.vector.length;i++){ 
            this.copyVector[i] = this.vector[i];
        }
    }
    
}
