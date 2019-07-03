/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

import java.util.Arrays;

/**
 *
 * @author giova
 */
public class mainCycBarrier {
    
    public static void main(String[] args) throws InterruptedException {

        double[] vetor = new double[]{1, 2, 2, 1, 3, 4, 5, 6, 8, 7, 2, 3, 4, 6, 8, 3};
        int count_itera=0;
        int iteracoes=10;
        ThreadPrincipal threadPrincipal = new ThreadPrincipal(vetor, iteracoes,vetor.length);
        threadPrincipal.start();
        while (count_itera <= iteracoes) {
            threadPrincipal.join();
            count_itera++;
            threadPrincipal.doneBarrier.reset();
            System.out.println(Arrays.toString(vetor));
        }
        
        
    }
}
