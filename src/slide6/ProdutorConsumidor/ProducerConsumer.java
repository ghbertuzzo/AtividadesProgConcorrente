/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Atividade: Implemente uma solução para o problema do
    Produtor-Consumidor
 */

package slide6.ProdutorConsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    public static void main(String[] args) {

        Objeto objeto = new Objeto("");

        Thread producer = new Thread(() -> {
            while (true) {
                Random rand = new Random();
                int n = rand.nextInt(5);
                int tempo = n * 1000;
                try {
                    Thread.currentThread().sleep(tempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
                synchronized (objeto) {
                    if (objeto.getBuffer().isEmpty()) {
                        objeto.setBuffer("Novo Objeto");
                        System.out.println("Produtor say: New Object produced -> " + objeto.getBuffer());

                        objeto.notify();

                    } else {
                        try {
                            objeto.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        producer.start();

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (objeto) {
                    if (!objeto.getBuffer().isEmpty()) {
                        System.out.println("Consumer say: New Object consumed " + objeto.getBuffer());
                        objeto.setBuffer("");
                        objeto.notify();
                    } else {
                        try {
                            objeto.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        consumer.start();
    }

}
