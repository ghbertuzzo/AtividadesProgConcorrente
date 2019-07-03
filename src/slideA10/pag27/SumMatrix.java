/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slideA10.pag27;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class SumMatrix extends Thread {
    
    int[][] matriz1;
    int[][] matriz2;
    int[][] matriz3;
    int linhas;
    int nthread;
    
    public SumMatrix(int[][] matriz1, int[][] matriz2, int[][] matriz3, int parts, int nthr){
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
        for(int i=0;i<=linhas;i++){
            tp = new ThreadProc2(matriz1,matriz2,matriz3,i);
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
