/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça um programa usando Lock para simular a atualização de
    um contador que é acessado por múltiplas threads.  O
    contador pode diminuir e aumentar.
 */

package slide9.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex1CounterLock {

    int counter;
    Lock lock;

    public Ex1CounterLock() {
        counter = 0;
        lock = new ReentrantLock();
    }

    public void increment() {
        lock.lock();
        try {
            counter++;
            System.out.println("Valor Atual: " + counter);
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            counter--;
            System.out.println("Valor Atual: " + counter);
        } finally {
            lock.unlock();
        }
    }

}
