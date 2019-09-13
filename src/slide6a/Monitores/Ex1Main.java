/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Implemente uma solução com monitor para o problema do
    Produtor-Consumidor usando um buffer circular
 */

package slide6a.Monitores;

public class Ex1Main {
    
    public static void main(String[] args) {
        Ex1CircularProducerConsumer ex1 = new Ex1CircularProducerConsumer(5);
        ex1.stort();
    }
    
}
