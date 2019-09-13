/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil
    Implementação: Barreiras cíclicas
        - Criar uma barreira cíclica com N-2 partes.
        - Criar N-2 tarefas para serem executadas em paralelo por threads.
        - No final de cada iteração, cada thread espera na barreira até todas outras alcançarem.
        - Arrays são invertidos e nova iteração inicia.
        Observar que:
            - Nenhuma thread é liberada depois de cada iteração, então o thread 
            pool deve ter no mínimo o número de tarefas (N-2).
 */

package slide9.Atividades;

import java.util.concurrent.CyclicBarrier;

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



