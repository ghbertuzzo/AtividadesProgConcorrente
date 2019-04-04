/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex3ThreadInterrupt extends Thread {

    @Override
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        int tempo = n * 1000;
        try {
            this.sleep(tempo);
        } catch (InterruptedException ex) {
            System.out.println("Sou a Thread " + this.getId() + " e fui interrompida.");
        }finally{
            System.out.println("Teste");
        }
        System.out.println("Sou a Thread " + this.getId() + " e esperei por "+ n +" segundos antes de morrer.");
    }
    
    public static void main(String[] args) {
        
        for(int i = 0; i<5; i++){
            Thread t = new Thread(new Ex3ThreadInterrupt());
            t.start();
            Random rand = new Random();
            int n = rand.nextInt(2);
            if(n==1){
                t.interrupt();
            }
        }
        System.out.println("Main thread execution completes"); 
    }
    
}
