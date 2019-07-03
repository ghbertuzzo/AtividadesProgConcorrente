/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slideA10.pag27;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author giova
 */
public class Ex1Main {
    public static void main(String[] args){      
        int sizevetor = 300;
        int[] vetor = new int[sizevetor];
        Random rand = new Random();
        for(int i=0;i<sizevetor;i++){
            int x = rand.nextInt(1000);
            vetor[i]=x;
        }
        for(int i=0;i<vetor.length;i++){
            System.out.print(" "+vetor[i]);            
        }
        System.out.println("");
        int nThreads=3;
        HighestValueThread hvt = new HighestValueThread(vetor, 7, nThreads);
        hvt.start();
    }
}
