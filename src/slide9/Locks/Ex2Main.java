/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Crie uma classe SharedFifoQueue e use Conditions para
    controlar se a fila está vazia ou cheia. Teste usando threads
    produtoras e consumidoras.
 */

package slide9.Locks;

public class Ex2Main {
    
    public static void main(String[] args) {
        SharedFifoQueue sfq = new SharedFifoQueue(10);
        Consumidor consumidor = new Consumidor(sfq);
        consumidor.start();
        Produtor produtor = new Produtor(sfq);
        produtor.start();
    }
}
