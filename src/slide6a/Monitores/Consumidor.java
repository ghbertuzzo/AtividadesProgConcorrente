/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide6a.Monitores;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giova
 */
public class Consumidor extends Thread {

    Ex1CircularProducerConsumer mymonitor;
    
    public Consumidor(Ex1CircularProducerConsumer myclass) {
        this.mymonitor = myclass;
    }

    @Override
    public void run() {
        while(true){
           try {
              this.mymonitor.consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
        
    }
}
