/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag28;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex1StateThreads {
    
    public static void main(String[] args) throws InterruptedException {
        
        ThreadX thread = new ThreadX();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());        
        new Thread(() -> {
            
        }).start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
    }
    
    private static class ThreadX extends Thread {
        @Override
        public void run() {  
            try {                    
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex1StateThreads.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
}
