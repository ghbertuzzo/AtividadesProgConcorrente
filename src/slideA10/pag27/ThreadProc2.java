/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

public class ThreadProc2 implements Runnable {

    int[][] matriz1;
    int[][] matriz2;
    int[][] matriz3;
    int linha;

    public ThreadProc2(int[][] matriz1, int[][] matriz2, int[][] matriz3, int linha) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matriz3 = matriz3;
        this.linha = linha;
    }

    @Override
    public void run() {
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

    }

}
