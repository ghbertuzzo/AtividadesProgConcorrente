/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    3. Faça um programa em Java com threads que exiba os
    números primos entre 0 e 100000.
 */

package slide3.pag28;

import java.util.ArrayList;

public class Ex3PrimeThread extends Thread {

    ArrayList<Integer> list;
    int init;
    int fin;
    final Object objeto;

    public Ex3PrimeThread(ArrayList<Integer> list, int init, int fin) {
        this.list = list;
        this.init = init;
        this.fin = fin;
        objeto = true;
    }

    @Override
    public void run() {
        for (int i = this.init; i <= this.fin; i++) {
            if (isPrime(i)) {
                synchronized (objeto) {
                    this.list.add(i);
                }
            }
        }
        System.out.println("Thread " + this.getName() + " finalizou.");
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();

        Ex3PrimeThread thread1 = new Ex3PrimeThread(list, 2, 33333);
        Ex3PrimeThread thread2 = new Ex3PrimeThread(list, 33334, 66666);
        Ex3PrimeThread thread3 = new Ex3PrimeThread(list, 66667, 100000);

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();

        System.out.println(list.size());
        list.forEach((i) -> {
            System.out.println(i);
        });

    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
