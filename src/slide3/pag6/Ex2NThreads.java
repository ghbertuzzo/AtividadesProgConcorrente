/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag6;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author a1602020
 */
public class Ex2NThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here.
        Integer nthreads = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de Threads:"));
        ArrayList lista = new ArrayList();
        for(int i = 0; i<nthreads; i++){
            Thread t = new Thread(() -> {
                System.out.println("Thread Iniciada");
                while(true){
                    System.out.println("Thread Hello Message");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ex2NThreads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
            lista.add(t);
        }
        System.out.println(lista.size()+" Threads em execução");        
    }    
}
