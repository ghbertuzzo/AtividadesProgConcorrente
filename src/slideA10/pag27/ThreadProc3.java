/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

public class ThreadProc3 implements Runnable {

    int[][] matriz1;
    int[][] matriz2;
    int[][] matriz3;
    int linha;
    int m;
    int n;
    int o;

    public ThreadProc3(int[][] matriz1, int[][] matriz2, int[][] matriz3, int linha, int m, int n, int o) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matriz3 = matriz3;
        this.linha = linha;
        this.m = m;
        this.n = n;
        this.o = o;
    }

    @Override
    public void run() {

        //for (int i = 0; i < matriz1.length; i++){
        for (int j = 0; j < matriz2[0].length; j++) {
            int somatoria = 0;
            for (int k = 0; k < matriz1[0].length; k++) {
                int produto = matriz1[linha][k] * matriz2[k][j];
                somatoria += produto;
            }
            matriz3[linha][j] = somatoria;
        }
        //}
    }

}
