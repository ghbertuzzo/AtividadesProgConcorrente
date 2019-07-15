/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag28;

import java.util.Random;

/**
 *
 * @author giova
 */
public class Ex5Main {
    
    public static void main(String[] args) throws InterruptedException{
        int SIZE=10;
        int[] actual = new int[SIZE];
        Random rand = new Random();
        for(int i=0;i<SIZE;i++){
            int value = rand.nextInt(100);
            actual[i] = value;
        }
        for(int i=0;i<actual.length;i++){
            System.out.println(" "+actual[i]);
        }
        int meio = SIZE/2;
        int[] vet1 = new int[meio];
        int[] vet2 = new int[meio];
        
        for(int i=0;i<actual.length;i++){
            if(i>=meio)
                vet2[i-meio]=actual[i];
            else
                vet1[i]=actual[i];
        }
        System.out.println(" ");
        for(int i=0;i<vet1.length;i++){
            System.out.println(" "+vet1[i]);
        }
        System.out.println(" ");
        for(int i=0;i<vet2.length;i++){
            System.out.println(" "+vet2[i]);
        }
        System.out.println(" ");
        ThreadMergeSort tms1 = new ThreadMergeSort(vet1,vet1.length);
        ThreadMergeSort tms2 = new ThreadMergeSort(vet2,vet2.length);
        tms1.join();
        tms2.join();       
        
        for(int i=0;i<vet1.length;i++){
            System.out.println(" "+vet1[i]);
        }
        for(int i=0;i<vet2.length;i++){
            System.out.println(" "+vet2[i]);
        }
    }        
    
}
