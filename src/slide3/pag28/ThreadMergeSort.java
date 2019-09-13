/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide3.pag28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadMergeSort extends Thread {

    int[] vector;
    int tamanho;

    public ThreadMergeSort(int[] vetor, int tamanho) {
        this.vector = vetor;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        mergeSort.mergeSort(vector, this.tamanho);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadMergeSort.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
