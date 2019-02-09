/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;
import java.util.ArrayList; // import the ArrayList class
/**
 *
 * @author Tijmen
 */
public class Model {
    
    //Initialise Variables
    private String word = "";//Word you're trying to guess
    private StringBuilder wordProgress = new StringBuilder("");
    private ArrayList<Character> triedChars = new ArrayList<>();
    
    private int mistakes = 0;
    private final static int MAX_MISTAKES = 10;
    
    //TODO: WORDGENERATOR
    
    //Default constructor
    Model(){
        word = "test";//Default testing word
        
        //Set guessed word to dots equal to length of word
        initGuessedWord();
    }
    
    //Constructor with string
    Model(String word){
        this.word = word;
        initGuessedWord();
    }
    
    //Checks if you've won yet
    public boolean hasWon(){
        return word.equals(wordProgress.toString());
    }
    
    //Checks if a letter is in the word, changes the guessed word if the letter is in the word
    public boolean letterInWord(char letter){
        addCharacter(letter);//You could instead do this in Hangman.java
        boolean inWord = false;
        for (int i=0; i < word.length(); i++){
            if (letter == word.charAt(i)){
                wordProgress.setCharAt(i, letter);
                inWord = true;
            }
        }
        return inWord;
    }
    
    //Add one to mistakes
    public void addMistake(){
        mistakes++;
    }
    
    //get number of mistakes
    public int getMistakes(){
        return mistakes;
    }
    
    //Returns the number of mistakes left
    public int getMistakesLeft(){
        return MAX_MISTAKES - mistakes;
    }
    
    //Checks if a character has allready been tried
    public boolean isCharacterTried(char c){
        return triedChars.contains(c);
    }

    //Add character to tried character list
    public void addCharacter(Character c){
        triedChars.add(c);
    }
    
    //get all of the guessed characters
    public ArrayList<Character> getTriedChars(){
        return triedChars;
    }
        //get the guessing word
    public String getGuessedWord(){
        return wordProgress.toString();
    }
    
    public String getWord(){
        return word;
    }
    
    //Initialise the guessing word thing
    private void initGuessedWord(){
        //Set guessed word to dots equal to length of word
        for (int i = 0; i < this.word.length(); i++){
            this.wordProgress.append(".");
        }
    }
}
