/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

import java.util.Random;

public class Ex1Main3 {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int m = rand.nextInt(4) + 1;
        int n = rand.nextInt(4) + 1;
        int[][] matriz1 = new int[m][n];
        int o = rand.nextInt(4) + 1;
        int[][] matriz2 = new int[n][o];
        int[][] matriz3 = new int[m][o];
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = rand.nextInt(5);
                matriz1[i][j] = x;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < o; j++) {
                int x = rand.nextInt(5);
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < o; j++) {
                System.out.print(" " + matriz2[i][j]);
            }
            System.out.println();
        }

        int nThreads = 1;
        MultMatrix mm = new MultMatrix(matriz1, matriz2, matriz3, m, n, o, nThreads);
        mm.start();
        mm.join();
        System.out.println();
        System.out.println("Matriz A*B: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < o; j++) {
                if (matriz3[i][j] < 10) {
                    System.out.print(" 0" + matriz3[i][j]);
                } else {
                    System.out.print(" " + matriz3[i][j]);
                }
            }
            System.out.println();
        }
    }
}
