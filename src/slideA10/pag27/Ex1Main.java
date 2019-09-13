/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

import java.util.Random;

public class Ex1Main {

    public static void main(String[] args) {
        int sizevetor = 300;
        int[] vetor = new int[sizevetor];
        Random rand = new Random();
        for (int i = 0; i < sizevetor; i++) {
            int x = rand.nextInt(1000);
            vetor[i] = x;
        }
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + vetor[i]);
        }
        System.out.println("");
        int nThreads = 3;
        HighestValueThread hvt = new HighestValueThread(vetor, 7, nThreads);
        hvt.start();
    }
}
