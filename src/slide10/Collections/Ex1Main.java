/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide10.Collections;

import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author a1602020
 */
public class Ex1Main {
    
    public static void main(String[] args) {
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<>(500);
        
        for(int i=0;i<5;i++){
            Thread produtor = new Thread(new Produtor(array));
            produtor.start();
        }
        for(int i=0;i<5;i++){
            Thread consumidor = new Thread(new Consumidor(array));
            consumidor.start();
        }
    }
    
}
