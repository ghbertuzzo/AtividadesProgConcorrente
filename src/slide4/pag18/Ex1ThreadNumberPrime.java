/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1.  Faça um programa em Java que use Threads para encontrar
        os números primos dentro de um intervalo.  O método que
        contabiliza os números primos deve possuir como entrada:
        valor inicial e final do intervalo, número de threads.
 */

package slide4.pag18;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1ThreadNumberPrime extends Thread {

    Intervalo interval;

    public Ex1ThreadNumberPrime(Intervalo interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        while (interval.getInitfinal() != interval.getInitial()) {
            int number = interval.getNext();
            boolean verify = isPrime(number);
            if (verify) {
                System.out.println("Numero primo: " + number);
                interval.getValues().add(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Valor inicial do intervalo:");
        int intervalInit = scan.nextInt();
        System.out.println("Valor final do intervalo:");
        int intervalFinal = scan.nextInt();
        System.out.println("Numero de Threads:");
        int numThreads = scan.nextInt();
        ArrayList<Integer> values = new ArrayList<>();
        Intervalo interval = new Intervalo(intervalInit, intervalFinal, values);

        for (int i = 0; i <= numThreads; i++) {
            Thread t = new Thread(new Ex1ThreadNumberPrime(interval));
            t.start();
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Intervalo {

        public int initial;
        public int initfinal;
        public ArrayList<Integer> values;

        public Intervalo(int initial, int initfinal, ArrayList<Integer> values) {
            this.initial = initial;
            this.initfinal = initfinal;
            this.values = values;
        }

        public int getInitial() {
            return initial;
        }

        public void setInitial(int initial) {
            this.initial = initial;
        }

        public int getInitfinal() {
            return initfinal;
        }

        public void setInitfinal(int initfinal) {
            this.initfinal = initfinal;
        }

        public ArrayList<Integer> getValues() {
            return values;
        }

        public void setValues(ArrayList<Integer> values) {
            this.values = values;
        }

        public int getNext() {
            return this.initial++;
        }
    }
}
