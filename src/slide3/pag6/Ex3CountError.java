/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    3. Faça um programa em Java que leia o número de Threads que
    incrementam a mesma variável
 */

package slide3.pag6;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ex3CountError extends Thread {

    Contador contador;

    public Ex3CountError(Contador cont) {
        contador = cont;
    }

    @Override
    public void run() {
        // your code here
        while (true) {
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
        for (int i = 0; i < nthreads; i++) {
            Thread t = new Thread(new Ex3CountError(cont));
            t.start();
            lista.add(t);
        }
    }
}

class Contador {

    public Contador() {
        this.contador = 0;
    }

    public int getContador() {
        return contador;
    }

    public void incrementa() {
        this.contador = this.contador + 1;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void print() {
        System.out.println("Valor atual do contador: " + this.contador);
    }

    int contador;
}
