/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag6;

/**
 *
 * @author a1602020
 */
public class Ex1LambdaThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t = new Thread(() -> {
            System.out.println("Testando thread com lambda");
        });
        t.start();
        
        new Thread(() -> System.out.println("Testando thread com lambda")).start();
    }
    
}
