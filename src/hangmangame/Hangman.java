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
public class Hangman {
    
    //Initialise variables
    private Model model;
    private View view;
    
    //Useless constructor
    public Hangman(){
    }
    
    public void run() throws IOException{
        
        view = new View();
        
        view.message("Welcome to Hangman!!!");
        view.message("Enter or word or press Enter for a random word");
        
        String word = view.getString();
        if (word.length() == 0){
            
            //Should pick a word from wordreader
            view.message("Randomly picking a word!");
            model = new Model();
            
        } else {
            
            //Using user input as word
            view.message("Using your word!");
            model = new Model(word);
        }
        
        //As long as you haven't lost or wonn, do this loop
        while ( model.getMistakesLeft() > 0 && model.hasWon() == false){
            view.message("Enter a letter:");
            String input = view.getString();
            
            //Check if user inputted 1 character or more
            if (input.length() == 1){
                Character inputChar = input.charAt(0);//Take fist character
                
                //Check if the character has already been tried
                if(!model.isCharacterTried(inputChar)){
                    
                    //Check if the letter is in the word  (Also adds 1 to mistakes if it's a mistake)
                    if (model.letterInWord(inputChar)){
                        
                        view.message("character in the word :D");
                        view.currentHangman(model.getMistakesLeft(), model.getGuessedWord(), model.getTriedChars());
                    
                    //Message if the letter is not in the word
                    } else {
                        
                        view.message("character not in the word :(");
                        model.addMistake();
                        view.currentHangman(model.getMistakesLeft(), model.getGuessedWord(), model.getTriedChars());
                    }
                
                //Message if the player tried a character he'd allready tried before
                } else {
                    view.message("Allready tried this one >:|");
                }
                
            //Message if the player didn't enter 1 character
            } else {
                view.message("please enter a single letter");
            }
        }
        view.message("");
        //Message if the player has won
        if(model.hasWon()){
            view.message("You Win!!!");
            view.message("You made " + model.getMistakes() + " mistakes in total");
            view.message("The word is: " + model.getWord());
        
        //Message if the player has lost
        } else {
            view.message("You Lose");
            view.message("You got to: " + model.getGuessedWord());
            view.message("The word is: " + model.getWord());
            
        }
    }
}
