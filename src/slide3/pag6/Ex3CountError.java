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
public class Ex3CountError extends Thread {    
    Contador contador;    
    
    public Ex3CountError(Contador cont) {
        contador = cont;
    }    
    @Override
    public void run() {
        // your code here
        while(true){
            contador.incrementa();
            contador.print();
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex3CountError.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        Contador cont = new Contador();
        Integer nthreads = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de Threads:"));
        ArrayList lista = new ArrayList();        
        for(int i = 0; i<nthreads; i++){
            Thread t = new Thread(new Ex3CountError(cont));
            t.start();
            lista.add(t);
        }
    }
}

class Contador{

    public Contador (){
        this.contador = 0;
    }
    
    public int getContador() {
        return contador;
    }
    
    public void incrementa(){
        this.contador = this.contador + 1;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void print (){
        System.out.println("Valor atual do contador: "+this.contador);
    }
    
    int contador;
}


