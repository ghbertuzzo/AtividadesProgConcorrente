/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
    
    5. Faça uma thread Java que fica aguardando uma sequência
    numérica de tamanho arbitrário digitado por usuário para
    realizar uma soma. Use o join().
 */

package slide3.pag17;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex5ThreadSumSequence extends Thread {

    public static ArrayList<Integer> values;

    @Override
    public void run() {
        values = new ArrayList<>();
        values.add(1);//gambiarra
        while (values.get(values.size() - 1) != 0) {
            int resp = -1;
            System.out.println("Digite o numero para somar (0 para sair): ");
            resp = new Scanner(System.in).nextInt();
            values.add(resp);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int resultado = 0;
        Thread t = new Ex5ThreadSumSequence();
        t.start();
        t.join();
        int tam = 0;
        tam = values.size();
        for (int i = 0; i < values.size(); i++) {
            resultado = values.get(i) + resultado;
        }
        System.out.println("total: " + (resultado - 1));//"-1" cont. gambiarra
    }
}
