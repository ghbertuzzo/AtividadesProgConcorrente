/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    Problema: One-Dimensional Stencil
    Implementação: Latch
        - Criar um novo latch para cada iteração com um contador igual N-2.
        - Criar N-2 tarefas para serem executadas em paralelo por threads. Uma thread principal espera
            todas as tarefas. Cada tarefa calcula o valor de 1 elemento do vetor.
        - Uma tarefa termina e avisa a thread principal que finalizou.
 */

package slide9.Atividades;

public class mainLatche {
    public static void main(String[] args) throws InterruptedException {
        LatcheOneDimensional lod = new LatcheOneDimensional(10,100);
    }
}
