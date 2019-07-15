/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag28;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class ThreadMergeSort extends Thread {
    
    int[] vector;
    int tamanho;
    
    public ThreadMergeSort(int[] vetor, int tamanho){
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
