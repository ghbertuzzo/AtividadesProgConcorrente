/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    2. Escreva um monitor Counter que possibilita um processo
    dormir até o contador alcançar um valor.  A classe Counter
    permite duas operações: increment() e sleepUntil(int x).
 */

package slide6a.Monitores;

public class Ex2Main {
    
    public static void main(String[] args) throws InterruptedException {
        Ex2ThreadCountSleep etcs = new Ex2ThreadCountSleep(3);
        etcs.init();
    }
    
}
