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
public class ThreadInterruptor extends Thread {
    public ArrayList<Thread> list;
    public int listSize;
    
    public ThreadInterruptor(ArrayList<Thread> list, int listSize) {
        this.list = list;
        this.listSize = listSize;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public void setList(ArrayList<Thread> list) {
        this.list = list;
    }

    public ArrayList<Thread> getList() {
        return list;
    }
    
    @Override
    public void run() {        
        while(true){
            Random rand = new Random();
            int n = rand.nextInt(listSize);
            if(!list.get(n).interrupted()){
                list.get(n).interrupt(); 
                System.out.println("Sou a Thread " + list.get(n).getId() + " e fui interrompida pela ThreadInterruptor.");
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0 ; i<listSize; i++){
                int cont = 0;
                if(list.get(i).interrupted())
                    cont++;
                if(cont==listSize){
                    System.out.println("Todas threads já foram mortas, agora vou me matar");
                    this.currentThread().interrupt();
                }                    
            }
        }        
    }
    
}
