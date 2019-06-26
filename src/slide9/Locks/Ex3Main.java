/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide9.Locks;

/**
 *
 * @author giova
 */
public class Ex3Main {
    
    public static void main(String[] args) {        
        ArrayListThreadSafe alts = new ArrayListThreadSafe();
        for(int i=0;i<2;i++){
            Leitor leitor = new Leitor(alts);
            leitor.start();
        }
        for(int i=0;i<5;i++){
            Escritor escritor = new Escritor(alts);
            escritor.start();
        }
    }
}
