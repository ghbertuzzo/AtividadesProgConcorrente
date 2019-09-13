/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    5. Faça um programa multithreaded em Java que ordene um
    vetor usando o Merge Sort recursivo. Faça com que a thread
    principal dispare duas threads para classificar cada metade do
    vetor.
 */

package slide3.pag28;

import java.util.Random;

public class Ex5Main {

    public static void main(String[] args) throws InterruptedException {
        int SIZE = 10;
        int[] actual = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            int value = rand.nextInt(100);
            actual[i] = value;
        }
        for (int i = 0; i < actual.length; i++) {
            System.out.println(" " + actual[i]);
        }
        int meio = SIZE / 2;
        int[] vet1 = new int[meio];
        int[] vet2 = new int[meio];

        for (int i = 0; i < actual.length; i++) {
            if (i >= meio) {
                vet2[i - meio] = actual[i];
            } else {
                vet1[i] = actual[i];
            }
        }
        System.out.println(" ");
        for (int i = 0; i < vet1.length; i++) {
            System.out.println(" " + vet1[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < vet2.length; i++) {
            System.out.println(" " + vet2[i]);
        }
        System.out.println(" ");
        ThreadMergeSort tms1 = new ThreadMergeSort(vet1, vet1.length);
        ThreadMergeSort tms2 = new ThreadMergeSort(vet2, vet2.length);
        tms1.join();
        tms2.join();

        for (int i = 0; i < vet1.length; i++) {
            System.out.println(" " + vet1[i]);
        }
        for (int i = 0; i < vet2.length; i++) {
            System.out.println(" " + vet2[i]);
        }
    }

}
