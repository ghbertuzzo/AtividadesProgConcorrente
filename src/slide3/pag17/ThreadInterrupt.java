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
public class ThreadInterrupt extends Thread {
    
    public ArrayList<Thread> list;
    public int listSize;
    
    public ThreadInterrupt(ArrayList<Thread> list, int listSize) {
        this.list = new ArrayList<>(list);
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
        int[] check = new int[5];
        check[0] = -1;
        check[1] = -1;
        check[2] = -1;
        check[3] = -1;
        check[4] = -1;        
        while(true){
            Random rand = new Random();
            int n = rand.nextInt(list.size());
            list.get(n).interrupt();
            System.out.println("ThreadInterrupt say: Interrompi a thread N = "+n);
            check[n] = n;
            if(check[0]!=-1){
                if(check[1]!=-1){
                    if(check[2]!=-1){
                        if(check[3]!=-1){
                            if(check[4]!=-1){
                                System.out.println("ThreadInterrupt say: TODAS THREADS INTERROMPIDAS.");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
    }
    
}
