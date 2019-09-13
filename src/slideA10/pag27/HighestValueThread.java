/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA10.pag27;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HighestValueThread extends Thread {

    int[] vetor;
    int parties;
    int nthread;

    public HighestValueThread(int[] vector, int parts, int nthr) {
        this.vetor = vector;
        this.parties = parts;
        this.nthread = nthr;
    }

    @Override
    public void start() {

        ArrayList<ThreadProc> tarefas = new ArrayList<>();
        ThreadProc tp;

        int inc = this.vetor.length / this.parties;
        int i = 0;
        for (i = 0; i < this.vetor.length; i += inc) {
            int j = i + inc;
            if (j < vetor.length) {
                tp = new ThreadProc(this.vetor, i, j);
                tarefas.add(tp);
            } else {
                tp = new ThreadProc(this.vetor, i, this.vetor.length);
                tarefas.add(tp);
            }
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(nthread);

        //executa as tarefas
        tarefas.forEach((tarefa) -> {
            threadPool.execute(tarefa);
        });
        threadPool.shutdown();

    }

}
