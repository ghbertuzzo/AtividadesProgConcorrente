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
public class Produtor extends Thread{

    SharedFifoQueue sfq;
    
    public Produtor(SharedFifoQueue sfq) {
        this.sfq = sfq;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            Random rand = new Random();            
            valor = rand.nextInt(10);
            sfq.setValorLista(valor);
            System.out.println("Produzido: "+valor);
            try {
                sleep(valor);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
