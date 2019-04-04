/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide3.pag17;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1602020
 */
public class Ex5ThreadSumSequence extends Thread {       
    
    public static ArrayList<Integer> values;
    
    @Override
    public void run() {
        values = new ArrayList<>();
        values.add(1);//gambiarra
        while(values.get(values.size()-1)!=0){
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
        for(int i = 0; i<values.size(); i++){
            resultado = values.get(i) + resultado;
        }
        System.out.println("total: "+(resultado-1));//"-1" cont. gambiarra
    } 
}
