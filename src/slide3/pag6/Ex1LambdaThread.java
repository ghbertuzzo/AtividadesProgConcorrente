/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    1. Faça um programa em Java que utilize a notação lambda.
 */

package slide3.pag6;

public class Ex1LambdaThread {

    public static void main(String[] args) {
        // TODO code application logic here
        Thread t = new Thread(() -> {
            System.out.println("Testando thread com lambda");
        });
        t.start();
        new Thread(() -> System.out.println("Testando thread com lambda")).start();
    }

}
