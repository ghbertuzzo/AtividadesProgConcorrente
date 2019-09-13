/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide7.pag9;

import java.util.concurrent.Semaphore;

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

