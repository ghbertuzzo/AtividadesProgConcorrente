/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Faça um programa usando Lock para simular a atualização de
    um contador que é acessado por múltiplas threads.  O
    contador pode diminuir e aumentar.
 */

package slide9.Locks;

public class Ex1Main {

    public static void main(String[] args) {
        Ex1CounterLock ex1 = new Ex1CounterLock();
        for (int i = 0; i < 10; i++) {
            ThreadCounter tc = new ThreadCounter(ex1);
            tc.start();
        }
    }

}
