/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class ThreadExec extends Thread {
    
    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getId()+" viva");
        while (true){            
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println("Thread "+Thread.currentThread().getId()+" say: morri");
                Thread.currentThread().interrupt();
                return;
            }
        }        
    }
    
}
