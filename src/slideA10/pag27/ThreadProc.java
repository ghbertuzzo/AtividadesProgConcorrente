/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

public class ThreadProc implements Runnable {

    int[] vetor;
    int init;
    int fin;

    public ThreadProc(int[] vector, int init, int fin) {
        this.vetor = vector;
        this.init = init;
        this.fin = fin;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        int maior = -1;
        for (int i = init; i < fin; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        System.out.println("\nInicio: " + init + " Fim: " + fin + " \nMaior desta parte: " + maior);
    }

}
