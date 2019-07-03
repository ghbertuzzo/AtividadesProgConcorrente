/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Atividades;

/**
 *
 * @author giova
 */
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
