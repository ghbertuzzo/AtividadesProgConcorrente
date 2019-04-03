/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class ThreadObserver extends Thread {

    public ArrayList<Thread> list;
    public int listSize;
    
    public ThreadObserver(ArrayList<Thread> list, int listSize) {
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
            for(int i = 0; i < this.listSize; i++){
                if(list.get(i).interrupted()){
                    System.out.println("Sou ThreadObserver e a Thread " + list.get(i).getId() + " foi interrompida.");                    
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }    
}
