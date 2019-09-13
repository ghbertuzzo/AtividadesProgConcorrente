/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumMatrix extends Thread {

    int[][] matriz1;
    int[][] matriz2;
    int[][] matriz3;
    int linhas;
    int nthread;

    public SumMatrix(int[][] matriz1, int[][] matriz2, int[][] matriz3, int parts, int nthr) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matriz3 = matriz3;
        this.linhas = parts;
        this.nthread = nthr;
    }

    @Override
    public void start() {

        ArrayList<ThreadProc2> tarefas = new ArrayList<>();
        ThreadProc2 tp;
        for (int i = 0; i <= linhas; i++) {
            tp = new ThreadProc2(matriz1, matriz2, matriz3, i);
            tarefas.add(tp);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(nthread);

        //executa as tarefas
        tarefas.forEach((tarefa) -> {
            threadPool.execute(tarefa);
        });
        threadPool.shutdown();

    }

}
