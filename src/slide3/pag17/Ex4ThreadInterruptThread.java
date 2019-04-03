/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author a1602020
 */
public class Ex4ThreadInterruptThread extends Thread {

    @Override
    public void run() {
        while(true){
            Random rand = new Random();
            int n = rand.nextInt(10);
            int tempo = n * 1000;
            try {
                this.sleep(tempo);
            } catch (InterruptedException ex) {
                System.out.println("Sou a Thread " + this.getId() + " e morri.");
                return;
            }        
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Thread> lista = new ArrayList();
        for(int i = 0; i<10; i++){
            Thread t = new Thread(new Ex4ThreadInterruptThread());
            t.start();
            lista.add(t);
        }
        ThreadObserver to = new ThreadObserver(lista, lista.size());
        to.start();
        ThreadInterruptor ti = new ThreadInterruptor(lista, lista.size());
        ti.start();
        System.out.println("Main thread execution completes"); 
    }
    
}
