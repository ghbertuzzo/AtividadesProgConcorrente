/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide4.pag18;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex2e3ThreadSafeNumberPrimeSyncBlock extends Thread {

    Intervalo interval;
    
    public Ex2e3ThreadSafeNumberPrimeSyncBlock(Intervalo interval) {
        this.interval = interval;
    }    
    
    @Override
    public void run() {
        long tempoInicial;
        long tempoFinal;
        tempoInicial = System.currentTimeMillis();
        while(interval.getInitfinal()!=interval.getInitial()){
            int number = interval.getNext();
            boolean verify = isPrime(number);
            if(verify){
                System.out.println(" numero primo: "+number);
                synchronized(this){
                    interval.getValues().add(number);                    
                }
            }
        }
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Thread "+Thread.currentThread().getId()+" tempo de execução: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
    
    public static void main(String[] args) throws InterruptedException {
        long tempoInicial;
        Scanner scan= new Scanner(System.in);
	System.out.println("Valor inicial do intervalo:");
        int intervalInit = scan.nextInt();
        System.out.println("Valor final do intervalo:");
        int intervalFinal = scan.nextInt();
        System.out.println("Numero de Threads:");
        int numThreads = scan.nextInt();          
        ArrayList<Integer> values = new ArrayList<>();
        Intervalo interval = new Intervalo(intervalInit, intervalFinal, values);
        ThreadGroup tg = new ThreadGroup("Group");
        tempoInicial = System.currentTimeMillis();
        for(int i = 0; i < numThreads; i++){
            Thread t = new Thread(tg,new Ex2e3ThreadSafeNumberPrimeSyncBlock(interval));
            t.start();
        }
        Sleeper sleeper = new Sleeper();
        sleeper.run();
        System.out.println("Valores: "+String.valueOf(interval.getValues()));
    }
    
    
    private synchronized boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static class Sleeper implements Runnable {

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex2e3ThreadSafeNumberPrimeSyncBlock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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

