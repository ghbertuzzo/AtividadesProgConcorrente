/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex2ThreadFrasesTxt {
    
    private static final String FILENAME = "src/slide3/pag17/frases.txt";
    
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t = new Thread(() -> {
            BufferedReader br = null;
            FileReader fr = null;
            while (true) {
                try {
                    fr = new FileReader(FILENAME);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
                br = new BufferedReader(fr);
                String sCurrentLine;
                try {
                    while ((sCurrentLine = br.readLine()) != null) {
                        System.out.println(sCurrentLine);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();        
    }
}
