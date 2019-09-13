/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
    Teste usando threads que realizam leitura e escrita para essa
    estrutura.
 */

package slide9.Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe {

    String content;
    ReentrantReadWriteLock readWriteLock;

    public ArrayListThreadSafe() {
        this.content = "";
        this.readWriteLock = new ReentrantReadWriteLock();

    }

    public void escrever(String texto) {
        this.readWriteLock.writeLock().lock();
        try {
            this.content += texto;
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    public String ler() {
        this.readWriteLock.readLock().lock();
        try {
            return this.content;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }
}
