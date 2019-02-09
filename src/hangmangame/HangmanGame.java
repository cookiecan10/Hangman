/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.io.IOException;

/**
 *
 * @author Tijmen
 */
public class HangmanGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Hangman h = new Hangman();
        h.Run();
        System.out.println("");
        System.out.println("Lol we just did one game, let's do another");
        System.out.println("");
        h.Run();
    }
    
}
