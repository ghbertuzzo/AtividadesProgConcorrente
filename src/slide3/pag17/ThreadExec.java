/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo    
 */

package slide3.pag17;

public class ThreadExec extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " viva");
        while (true) {
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println("Thread " + Thread.currentThread().getId() + " say: morri");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

}
