/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    3. Escreva um monitor BoundedCounter que possui um valor mínimo e máximo.  
    A classe possui dois métodos: increment() e decrement(). Ao alcançar os 
    limites mínimo ou máximo, a thread que alcançou deve ser bloqueada.
 */

package slide6a.Monitores;

public class Ex3Main {
    public static void main(String[] args) throws InterruptedException {
        Ex3BoundedCounter ex3 = new Ex3BoundedCounter(10, 100);
        ex3.stort();
    }
}
