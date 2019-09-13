/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slide6a.Monitores;

public class Ex2ThreadCountSleep {
    
    int time;
    int i;
    ThreadSleeper threadsleep;
    
    public Ex2ThreadCountSleep(int time) {
        this.i = 0;
        this.threadsleep = new ThreadSleeper(this);
        this.time = time;
    }

    public synchronized void increment() {
        this.i++;
        System.out.println("increment: "+this.i);
    }

    public synchronized void dormir() throws InterruptedException {
        System.out.println("Thread Dormiu! "+this.i);
        while (this.i < this.time) {
            this.threadsleep.sleep(1000);
            increment();
        }
        System.out.println("Thread Acordou!");
        this.i = 0;
    }

    public void init() throws InterruptedException {
        this.dormir();
    }
}
