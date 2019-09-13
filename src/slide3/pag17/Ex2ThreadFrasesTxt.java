/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo

    2. Faça uma thread Java que realize a leitura de um arquivo
    texto com frases e exiba as frases a cada 10 segundos.
 */
package slide3.pag17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex2ThreadFrasesTxt {

    private static final String FILENAME = "src/slide3/pag17/frases.txt";

    public static void main(String[] args) {
        // TODO code application logic here
        Thread t = new Thread(() -> {
            BufferedReader br = null;
            FileReader fr = null;
            while (true) {
                try {
                    fr = new FileReader(FILENAME);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
                br = new BufferedReader(fr);
                String sCurrentLine;
                try {
                    while ((sCurrentLine = br.readLine()) != null) {
                        System.out.println(sCurrentLine);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex2ThreadFrasesTxt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }
}
