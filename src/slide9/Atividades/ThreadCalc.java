/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil    
 */

package slide9.Atividades;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCalc extends Thread {

    int position;
    double[] vetor;
    CyclicBarrier doneBarrier;
    
    public ThreadCalc(int position, double[] vetor, CyclicBarrier doneBarrier) {
        this.position = position;
        this.vetor = vetor;
        this.doneBarrier = doneBarrier;    
    }
    
    @Override
    public void run() {
        //while(true){
        int await =-1;
            if((this.position!=0)&&(this.position!=vetor.length-1)){
                double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
                this.vetor[this.position] = valor;
            }
            try {
                await = this.doneBarrier.await();
                System.out.println("await; "+await);
            } catch (InterruptedException | BrokenBarrierException ex) {
                Logger.getLogger(ThreadCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
                
    }
    
}
