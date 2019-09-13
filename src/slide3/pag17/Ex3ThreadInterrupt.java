/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
    
    3. Faça um programa Java que envia interrupções para as
    threads dos exercı́cios anteriores. As threads devem fazer o
    tratamento dessas interrupções e realizar uma finalização
    limpa.
 */

package slide3.pag17;

import java.util.Random;

public class Ex3ThreadInterrupt extends Thread {

    @Override
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        int tempo = n * 1000;
        try {
            this.sleep(tempo);
        } catch (InterruptedException ex) {
            System.out.println("Sou a Thread " + this.getId() + " e fui interrompida.");
        }finally{
            System.out.println("Teste");
        }
        System.out.println("Sou a Thread " + this.getId() + " e esperei por "+ n +" segundos antes de morrer.");
    }
    
    public static void main(String[] args) {
        
        for(int i = 0; i<5; i++){
            Thread t = new Thread(new Ex3ThreadInterrupt());
            t.start();
            Random rand = new Random();
            int n = rand.nextInt(2);
            if(n==1){
                t.interrupt();
            }
        }
        System.out.println("Main thread execution completes"); 
    }
    
}
