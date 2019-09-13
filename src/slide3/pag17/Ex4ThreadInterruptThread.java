/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
    
    4. Faça uma Thread que monitora um conjunto de threads e
    exiba quais threads receberam sinais de interrupção.
 */

package slide3.pag17;

import java.util.ArrayList;

public class Ex4ThreadInterruptThread {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> lista = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Thread t = new ThreadExec();
            t.start();
            lista.add(t);
        }
        Thread ti = new ThreadInterrupt(lista, lista.size());
        ti.start();
        Thread to = new ThreadObserver(lista, lista.size());
        to.start();
    }

}
