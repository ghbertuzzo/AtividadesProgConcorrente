/*
    Universidade Tecnológica Federal do Paraná - UTFPR
    Disciplina Optativa: Programação Concorrente
    Autor: Giovani Henrique Bertuzzo
 */

package slideA11.pag17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1Main {

    static String filepath = "src\\slideA11\\pag17\\texto.txt";
    static int linesToSearch = 1;
    static int numTasks = 10;

    public static void main(String[] args) {
        try {
            ConcurrentMap<String, Integer> letters = new ConcurrentHashMap<>();
            ExecutorService threadPool = Executors.newFixedThreadPool(numTasks);
            ArrayList<Future> listTasks = new ArrayList<>();
            Scanner file = new Scanner(new FileReader(filepath));
            int countLine = 0;
            String content = "";
            while (file.hasNext()) {
                if (countLine >= linesToSearch) {
                    taskCount task = new taskCount(content, letters);
                    Future future = threadPool.submit(task);
                    listTasks.add(future);
                    countLine = 0;
                    content = "";
                }
                content += file.nextLine();
                countLine++;
            }
            for (Future ft : listTasks) {
                while (!ft.isDone()) {
                    Thread.sleep(1000);
                }
            }
            for (String key : letters.keySet()) {
                System.out.println(key + " " + letters.get(key));
            }
            threadPool.shutdown();

        } catch (FileNotFoundException | InterruptedException ex) {
            Logger.getLogger(Ex1Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
