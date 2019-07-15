/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slideA11.pag17;

/**
 *
 * @author giova
 */
import java.util.concurrent.ConcurrentMap;


public class taskCount implements Runnable {

    ConcurrentMap<String, Integer> letters;
    String content;

    public taskCount(String content, ConcurrentMap<String, Integer> letters) {
        this.letters = letters;
        this.content = content;
    }

    @Override
    public void run() {
        for (char letter : this.content.toCharArray()) {
            if (this.letters.containsKey(Character.toString(letter))) {
                this.letters.put(Character.toString(letter), this.letters.get(Character.toString(letter))+1);
            } else {
                this.letters.put(Character.toString(letter), 1);
            }
        }
    }

}