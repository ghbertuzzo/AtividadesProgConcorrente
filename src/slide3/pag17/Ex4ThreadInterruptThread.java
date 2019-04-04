/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex4ThreadInterruptThread{   
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> lista = new ArrayList();
        for(int i = 0; i<5; i++){
            Thread t = new ThreadExec();
            t.start();
            lista.add(t);  
        }
        Thread ti = new ThreadInterrupt(lista,lista.size());
        ti.start(); 
        Thread to = new ThreadObserver(lista, lista.size());
        to.start();
    }
    
}
