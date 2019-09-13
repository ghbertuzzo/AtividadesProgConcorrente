/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA11.Collections;

import java.util.concurrent.ArrayBlockingQueue;

public class Ex1Main {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<>(500);

        for (int i = 0; i < 5; i++) {
            Thread produtor = new Thread(new Produtor(array));
            produtor.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread consumidor = new Thread(new Consumidor(array));
            consumidor.start();
        }
    }

}
