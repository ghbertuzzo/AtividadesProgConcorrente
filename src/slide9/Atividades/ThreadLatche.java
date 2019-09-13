/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil
    Implementação: Latch
        - Criar um novo latch para cada iteração com um contador igual N-2.
        - Criar N-2 tarefas para serem executadas em paralelo por threads. Uma thread principal espera
            todas as tarefas. Cada tarefa calcula o valor de 1 elemento do vetor.
        - Uma tarefa termina e avisa a thread principal que finalizou.
 */

package slide9.Atividades;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

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
