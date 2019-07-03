/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slideA10.pag27;

/**
 *
 * @author giova
 */
public class ThreadProc implements Runnable {
    
    int[] vetor;
    int init;
    int fin;
    
    public ThreadProc(int[] vector, int init, int fin){
        this.vetor = vector;
        this.init = init;
        this.fin = fin;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        int maior = -1;
        for(int i=init;i<fin;i++){  
            if(vetor[i]>maior)
                maior = vetor[i];            
        }
        System.out.println("\nInicio: "+init+" Fim: "+fin+" \nMaior desta parte: "+maior);
    }
    
}
