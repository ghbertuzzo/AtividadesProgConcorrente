/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

import java.util.Random;

/**
 *
 * @author giova
 */
public class Ex2Main {
    
    public static void main(String[] args) {
        SharedFifoQueue sfq = new SharedFifoQueue(10);
        Consumidor consumidor = new Consumidor(sfq);
        consumidor.start();
        Produtor produtor = new Produtor(sfq);
        produtor.start();
    }
}
