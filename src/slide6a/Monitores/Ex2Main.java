 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide6a.Monitores;

/**
 *
 * @author giova
 */
public class Ex2Main {
    
    public static void main(String[] args) throws InterruptedException {
        Ex2ThreadCountSleep etcs = new Ex2ThreadCountSleep(3);
        etcs.init();
    }
    
}
