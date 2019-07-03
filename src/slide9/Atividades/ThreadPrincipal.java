/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author giova
 */
public class ThreadPrincipal extends Thread {

    double[] vetor;
    int numThreads;
    int count;
    CyclicBarrier doneBarrier;
    
    public ThreadPrincipal(double[] vetor, int iteracoes, int parties) {
        this.vetor = vetor;
        this.count = 0;
        this.numThreads = parties;
        this.doneBarrier = new CyclicBarrier(parties,new EstouroBarreira(this));
    }

    @Override
    public void run(){
        for(int i=1;i<vetor.length-1;i++){
            ThreadCalc threadcalc = new ThreadCalc(i,vetor,doneBarrier);
            threadcalc.start();
        }                    
    }
}



