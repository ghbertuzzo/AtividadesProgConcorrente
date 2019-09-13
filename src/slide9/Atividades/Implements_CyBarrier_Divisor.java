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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Implements_CyBarrier_Divisor implements Runnable {

    int position;
    double[] vetor;
    CyclicBarrier doneBarrier;

    public Implements_CyBarrier_Divisor(int position, double[] vetor, CyclicBarrier doneBarrier) {
        this.position = position;
        this.vetor = vetor;

        this.doneBarrier = doneBarrier;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
        }

        try {
            this.doneBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Implements_CyBarrier_Divisor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
