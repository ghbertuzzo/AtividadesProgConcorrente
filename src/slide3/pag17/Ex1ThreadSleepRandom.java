/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import slide3.pag6.Ex3CountError;

/**
 *
 * @author a1602020
 */
public class Ex1ThreadSleepRandom extends Thread {

    @Override
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        int tempo = n * 1000;
        try {
            this.sleep(tempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex1ThreadSleepRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sou a Thread " + this.getId() + " e esperei por "+ n +" segundos antes de morrer.");
    }
    
    public static void main(String[] args) {   
        for(int i = 0; i<3; i++){
            Thread t = new Thread(new Ex1ThreadSleepRandom());
            t.start();
        }
    }
    
}
