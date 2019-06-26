/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class Consumidor extends Thread{
    
    SharedFifoQueue sfq;

    public Consumidor(SharedFifoQueue sfq) {
        this.sfq = sfq;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.sfq.getValorLista();
            System.out.println("Consumido: "+valor);
            Random rand = new Random();            
            valor = rand.nextInt(10);
            try {
                sleep(valor);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
