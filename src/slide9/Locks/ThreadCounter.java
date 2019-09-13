/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça um programa usando Lock para simular a atualização de
    um contador que é acessado por múltiplas threads.  O
    contador pode diminuir e aumentar.
 */

package slide9.Locks;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCounter extends Thread {
    
    Ex1CounterLock ex1;
    
    public ThreadCounter (Ex1CounterLock exe){
        ex1 = exe;
    }
    
    @Override
    public void run() {
        while (true) { 
            Random rand = new Random();                
            int n = rand.nextInt(2);
            if(n==1){
                this.ex1.increment();
                System.out.println("Incremented by: Thread"+Thread.currentThread().getId());                
            }else{
                this.ex1.decrement();
                System.out.println("Decremented by: Thread"+Thread.currentThread().getId());     
            }
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sleep(int val) throws InterruptedException {
        Thread.sleep(val);
    }
    
}
