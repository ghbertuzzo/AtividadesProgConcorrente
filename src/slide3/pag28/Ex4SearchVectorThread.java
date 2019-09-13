/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    4. Faça um programa em Java que realize uma busca paralela
    em um vetor de inteiros. Informe para o método: valor
    procurado, vetor de inteiros e o número de threads.
 */

package slide3.pag28;

import java.util.Random;
import javax.swing.JOptionPane;

public class Ex4SearchVectorThread extends Thread {

    int init;
    int fin;
    int nsearch;
    int[] vet;

    @Override
    public void run() {
        for (int i = init; i < fin; i++) {
            if (vet[i] == this.nsearch) {
                System.out.println("Posicao [" + i + "] do vetor numero " + vet[i]);
            }
        }
    }

    public Ex4SearchVectorThread(int init, int fin, int searched, int[] vet) {
        this.init = init;
        this.fin = fin;
        this.nsearch = searched;
        this.vet = vet;
    }

    public static void main(String[] args) {

        Integer nsearch = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero procurado: "));
        Integer nthreads = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de Threads:"));
        int[] vet = generateVector();
        int size = vet.length / nthreads;
        int j = 0;
        System.out.println("size vetor " + vet.length);
        for (int i = 0; i < vet.length; i += size) {
            j += size;
            if (i + size < vet.length) {
                System.out.println("criando: i=" + i + " j=" + j);
                Ex4SearchVectorThread ex = new Ex4SearchVectorThread(i, j, nsearch, vet);
                ex.start();
            } else {
                System.out.println("criando: i=" + i + " j=" + vet.length);
                Ex4SearchVectorThread ex = new Ex4SearchVectorThread(i, vet.length, nsearch, vet);
                ex.start();
            }
        }

    }

    private static int[] generateVector() {
        Random generate = new Random();
        int init = generate.nextInt(10);
        int fim = generate.nextInt(10000);
        int[] vector = new int[fim - init];
        for (int i = 0; i < fim - init; i++) {
            vector[i] = generate.nextInt(1000);
        }
        return vector;
    }

}
