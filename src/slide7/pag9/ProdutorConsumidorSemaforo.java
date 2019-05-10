/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7.pag9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author a1602020
 */
public class ProdutorConsumidorSemaforo {
    
    public final int SIZEBUFFER = 10;
    int[] buffer = new int[SIZEBUFFER];
    int elements = 0;

    Semaphore produtores = new Semaphore(SIZEBUFFER);
    Semaphore consumidores = new Semaphore(0);
    Semaphore controlador = new Semaphore(1);
    
    public static void main(String[] args) { 
    
        
        
    }
    
    public void produz(int valor) throws InterruptedException{
        produtores.acquire();
        controlador.acquire();
        if(elements<SIZEBUFFER){
            buffer[elements] = valor;
            System.out.println("Produzido: "+buffer[elements]);
            elements++;
            consumidores.release();
        }
    }
    
    public void consome() throws InterruptedException{
        consumidores.acquire();
        controlador.acquire();
        if(buffer.length>0){
            System.out.println("Consumindo: "+buffer[SIZEBUFFER]);
            elements--;
            produtores.release();
        }
        
    }
    
    
}

