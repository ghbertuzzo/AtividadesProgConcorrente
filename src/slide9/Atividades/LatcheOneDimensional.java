/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author a1602020
 */
public class LatcheOneDimensional {
    
    float [] initialVector;
    float [] finalVector;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    
    public LatcheOneDimensional(int size, int iterations) throws InterruptedException{
        this.initialVector = new float[size];
        this.finalVector = new float[size];
        generateVector();
        this.startSignal = new CountDownLatch(1);
        this.doneSignal = new CountDownLatch(size);
        process(size,iterations);
    }
    
    private void generateVector() {
        for(int i = 0;i<this.initialVector.length;i++){          
            int n = new Random().nextInt(10);
            this.initialVector[i] = n;
        }                
        printVector(this.initialVector);
    }

    private void printVector(float[] vector) {
        System.out.print("| ");
        for(int i = 0;i<vector.length-1;i++){ 
            System.out.print(vector[i]+" - ");
        }  
        System.out.print(vector[vector.length-1]);
        System.out.print(" |\n");
    }
    private void process(int size, int iterations) throws InterruptedException {
        for(int i=0;i<iterations;i++){
            for(int j =0;j<size;j++){
                new Thread(new ThreadLatche(this.startSignal, this.doneSignal, this.initialVector, j)).start();
            }  
            this.startSignal.countDown();
            this.doneSignal.await();
            printVector(this.initialVector);
        }
    }
}
