/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Solução 2 para o Jantar dos Filósofos
 */

package slide8.ReaderWriter;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilosofosS2 extends Thread {

    final static int TEMPO_MAXIMO = 100;
    Mesa mesa;
    int filosofo;
    String nome;

    public FilosofosS2(String nome, Mesa mesa, int id) {
        this.nome = nome;
        this.mesa = mesa;
        this.filosofo = id;
    }

    @Override
    public void run() {
        while (true) {
            int tempo = (int) (Math.random() * TEMPO_MAXIMO);
            try {
                thinking();
            } catch (InterruptedException ex) {
                Logger.getLogger(FilosofosS2.class.getName()).log(Level.SEVERE, null, ex);
            }
            getGarfos();
            tempo = (int) (Math.random() * TEMPO_MAXIMO);
            eating();
            returnGarfos();
        }
    }

    public void thinking() throws InterruptedException {
        Integer rand = new Random().nextInt(100);
        sleep(rand);
    }

    public void eating() {
        System.out.println("Filosofo " + filosofo + " comendo.");
    }

    public void getGarfos() {
        mesa.pegarGarfos(filosofo);
    }

    public void returnGarfos() {
        mesa.returningGarfos(filosofo);
    }
}
