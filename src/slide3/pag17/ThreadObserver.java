/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo    
 */

package slide3.pag17;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadObserver extends Thread {

    public ArrayList<Thread> list;
    public int listSize;

    public ThreadObserver(ArrayList<Thread> list, int listSize) {
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
        while (true) {
            System.out.println("\n\nThreads Interrompidas:");
            for (int i = 0; i < listSize; i++) {
                if (list.get(i).isInterrupted()) {
                    System.out.println("ThreadObserver say: A thread " + list.get(i).getId() + " foi interrompida.");
                }
            }
            System.out.println("\n");
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
