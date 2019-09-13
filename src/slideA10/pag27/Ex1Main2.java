/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

import java.util.Random;

public class Ex1Main2 {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int m = rand.nextInt(10) + 1;
        int n = rand.nextInt(10) + 1;
        int[][] matriz1 = new int[m][n];
        int[][] matriz2 = new int[m][n];
        int[][] matriz3 = new int[m][n];
        System.out.println("Linhas: " + m);
        System.out.println("Colunas: " + n);
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = rand.nextInt(5);
                matriz1[i][j] = x;
                x = rand.nextInt(5);
                matriz2[i][j] = x;
            }
        }
        System.out.println("Matriz A: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matriz1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matriz B: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matriz2[i][j]);
            }
            System.out.println();
        }

        int nThreads = 3;
        SumMatrix sm = new SumMatrix(matriz1, matriz2, matriz3, m, nThreads);
        sm.start();
        sm.join();
        System.out.println();
        System.out.println("Matriz A+B: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matriz3[i][j]);
            }
            System.out.println();
        }
    }
}
