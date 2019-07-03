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
public class MultMatrix extends Thread {
    
    int[][] matriz1;
    int[][] matriz2;
    int[][] matriz3;
    int m;
    int n;
    int o;
    int nthread;
    
    public MultMatrix(int[][] matriz1, int[][] matriz2, int[][] matriz3, int m, int n, int o, int nthr){
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.matriz3 = matriz3;
        this.m = m;
        this.n = n;
        this.o = o;
        this.nthread = nthr;
    }

    @Override
    public void start() {
        
        ArrayList<ThreadProc3> tarefas = new ArrayList<>();
        ThreadProc3 tp;
        for(int i=0;i<m;i++){
            tp = new ThreadProc3(matriz1,matriz2,matriz3,i,m,n,o);
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
