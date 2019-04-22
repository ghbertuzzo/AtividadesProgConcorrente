/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide6.ProdutorConsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class ProdutorConsumidor {
    
        public final Object myMonitorObject = new Object();
        public boolean wasSignalled = false;  
        
    public static void main(String[] args) {
        // TODO code application logic here
              
        Object o[] = new Object[1];
        
        ThreadProducer tp = new ThreadProducer(o);
        tp.start();
        
        ThreadConsumer tc = new ThreadConsumer(o);
        tc.start();
        
    }
    
    public static class ThreadProducer extends Thread {
        Object[] o;
        
        private ThreadProducer(Object[] o) {
            this.o = o;
        }

        @Override
        public void run() {
            while(true){
                Random rand = new Random();
                int n = rand.nextInt(5);
                int tempo = n * 1000;
                try {
                    Thread.currentThread().sleep(tempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProdutorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(o[0]==null){
                    o[0] = new String("Objeto");
                    System.out.println("Produtor say: New Object produced -> "+o[0].toString());
                }
                //doNotify();
            }
        }
        
    }
    
    public static class ThreadConsumer extends Thread {

        Object[] o;
        
        private ThreadConsumer(Object[] o) {
            this.o = o;
        }

        @Override
        public void run() {
            while(true){
                System.out.println("Consumer say: New Object consumed "+o[0].toString());
                o[0] = null;
                //try {
                //    doWait();
                //} catch (InterruptedException ex) {
                //    Logger.getLogger(ProdutorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                //}
            }
        }
        
    }
    
    public void doWait() throws InterruptedException{
        synchronized (myMonitorObject){
            while(!wasSignalled){
                myMonitorObject.wait();
            }
            wasSignalled=false;            
        }
    }
    
    public void doNotify(){
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        }
    }
    
}
