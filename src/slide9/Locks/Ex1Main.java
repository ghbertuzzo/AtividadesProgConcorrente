/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

/**
 *
 * @author a1602020
 */
public class Ex1Main {
    
    public static void main(String[] args) {
        Ex1CounterLock ex1 = new Ex1CounterLock();        
        for(int i=0;i<10;i++){
            ThreadCounter tc = new ThreadCounter(ex1);
            tc.start();
        }
    }
    
}


