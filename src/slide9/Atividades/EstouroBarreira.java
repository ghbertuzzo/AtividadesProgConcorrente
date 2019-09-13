/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil    
 */

package slide9.Atividades;

public class EstouroBarreira implements Runnable {

    ThreadPrincipal stCode;

    public EstouroBarreira(ThreadPrincipal classe) {
        this.stCode = classe;
    }

    @Override
    public void run() {
        System.out.println("Estoura cont++");
        this.stCode.count++;
    }

}
