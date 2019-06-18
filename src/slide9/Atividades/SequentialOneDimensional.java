/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

import java.util.Random;

/**
 *
 * @author a1602020
 */
public class SequentialOneDimensional {
    
    float [] initialVector;
    float [] finalVector;

    public SequentialOneDimensional(int size, int loop) {
        this.initialVector = new float[size];
        this.finalVector = new float[size];
        generateVector();
        firstProcess();
        process(loop);
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

    private void process(int iterations) {
        for(int j =0;j<iterations;j++){
            copy();
            for(int i = 0;i<this.finalVector.length;i++){
                if(i==0 || i==this.finalVector.length-1){
                    this.finalVector[i] = this.initialVector[i];
                }else{
                    this.finalVector[i] = (this.initialVector[i-1]+this.initialVector[i+1])/2;
                }            
            } 
            printVector(this.finalVector);
        }      
    }
    private void firstProcess() {
        for(int i = 0;i<this.initialVector.length;i++){ 
            if(i==0 || i==this.initialVector.length-1){
                this.finalVector[i] = this.initialVector[i];
            }else{
                this.finalVector[i] = (this.initialVector[i-1]+this.initialVector[i+1])/2;
            }            
        }         
        printVector(this.finalVector);
    }

    private void copy() {
        for(int i = 0;i<this.finalVector.length;i++){ 
            this.initialVector[i] = this.finalVector[i];
        }
    }
    
    
}
