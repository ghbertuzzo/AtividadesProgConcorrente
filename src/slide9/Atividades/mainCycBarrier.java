/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil
    Implementação: Barreiras cíclicas
        - Criar uma barreira cíclica com N-2 partes.
        - Criar N-2 tarefas para serem executadas em paralelo por threads.
        - No final de cada iteração, cada thread espera na barreira até todas outras alcançarem.
        - Arrays são invertidos e nova iteração inicia.
        Observar que:
            - Nenhuma thread é liberada depois de cada iteração, então o thread 
            pool deve ter no mínimo o número de tarefas (N-2).
 */

package slide9.Atividades;

import java.util.Arrays;

public class mainCycBarrier {

    public static void main(String[] args) throws InterruptedException {

        double[] vetor = new double[]{1, 2, 2, 1, 3, 4, 5, 6, 8, 7, 2, 3, 4, 6, 8, 3};
        int count_itera = 0;
        int iteracoes = 10;
        ThreadPrincipal threadPrincipal = new ThreadPrincipal(vetor, iteracoes, vetor.length);
        threadPrincipal.start();
        while (count_itera <= iteracoes) {
            threadPrincipal.join();
            count_itera++;
            threadPrincipal.doneBarrier.reset();
            System.out.println(Arrays.toString(vetor));
        }

    }
}
