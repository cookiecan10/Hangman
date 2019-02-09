/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;
/**
 *
 * @author Tijmen
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {
    
    //Useless constructor
    View(){
        //maybe we could add a model in here, that way you can print stuff without having to pass too many parameters (like currentHangman() ) )
    }
    
    //Allows you to enter a word
    public String getString() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        return msg;
    }
    
    //Make a message through view (View can decide how the message will be shown)
    public void message(String m){
        System.out.println(m);
    }
    
    //WARNING THIS METHOD MAY NOT BE OBJECT ORIENTED
    //Shows the current stats of hangman
    public void currentHangman(int remainingMistakes, String guessingWord, ArrayList<Character> guessedLetters){
        message("Remaining Mistakes: " + remainingMistakes);
        message("Guessed letters: " + guessedLetters);
        message("Word: " + guessingWord);
    }
}
