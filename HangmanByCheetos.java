import java.util.Scanner;
import java.lang.Math;
import java.util.HashSet;

// ALL PROGRAM COMPLEXITY: O(n)

class Figure{
    private char hangMan [][];
    private int errors;

    // Builder: Initialize the matrix with ' ' and errors in 0
    Figure(){
        this.hangMan = new char[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.hangMan[i][j] = ' ';
            }
        }
        this.errors = 0;
    }

    // Set a wrong answer, draw a new part of the hangman and increment errors in 1    
    public void wrongAnswer(){
        this.errors += 1;
        switch (errors){
            case 1:
                this.hangMan[2][0] = '/';
                break;
            case 2:
                this.hangMan[2][2] = '\\';
                break;
            case 3:
                this.hangMan[1][1] = '|';
                break;
            case 4:
                this.hangMan[1][0] = '/';
                break;
            case 5:
                this.hangMan[1][2] = '\\';
                break;
            case 6:
                this.hangMan[0][1] = 'O';
                break;
        }
    }
     
    // Print the hangman matrix
    public void printHangMan(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                System.out.print(this.hangMan[i][j]+" ");
            System.out.println();
        }
    }

    // Check if errors are 6 for setting a game over
    public boolean checkForLose(){
        if(this.errors<6)
            return false;
        else{
            System.out.println("AHORCADO!");
            return true;
        }
            
    }
}

class Word{
    private String words [] = {"Cheetos", "Grafo", "Gus","Papeada",
                              "Zoologico", "Procrastinar", "Yordi", "Arbol", 
                              "Parangaricutitimicuaro", "Programacion"};
    private char word [];
    private char display [];
    private int wordSize;
    private int missingLetters;
    private HashSet<Character> used = new HashSet<Character>(); // Save the used words

    // Builder method: Selects a random word for the game and initializes all atributes.
    Word(){
        int max = 9;
        int min = 0;
        int range = max - min + 1;
        int index =(int)(Math.random() * range) + min;
        String temp = this.words[index];
        int n = temp.length();
        this.word = new char [n];
        this.display = new char [n];
        this.wordSize = n;
        this.missingLetters = n;

        for (int i = 0; i < n; i++) {
            char c = temp.charAt(i);
            this.word[i] = c;
            this.display[i] = '_';
        }

    }

    // Check if the word is discovered, already used or not in the target word
    public boolean checkForWord(char a){
        boolean flag = false;
        if(this.used.contains(a)){
            System.out.println("La letra ya fue usada, por jugarle al vivo ahi va otro error");
            return false;
        }
        for(int i=0; i<this.wordSize; i++){
            if(word[i] == a){
                display[i] = a;
                this.missingLetters -=1;
                flag = true;
            }
        }
        this.used.add(a);
        return flag;
    }

    // Check check if the word is complete
    public boolean checkForWin(){
        if(this.missingLetters == 0){
            System.out.println("GANASTE!");
            return true;
        }
        return false;
    }

    // Display the word at the screen
    public void printWord(){
        for(int i=0; i<this.wordSize; i++)
            System.out.print(this.display[i]+" ");
    }
}

public class HangmanByCheetos {
    public static void main(String[] args){
        Scanner stdio = new Scanner(System.in); // Scanner

        // Object instances
        Word game = new Word();
        Figure donChepe = new Figure();

        // Fill a set with all the alphabet characters, this will guarantee not desired inputs
        HashSet<Character> alphabet = new HashSet<Character>();
        for(char letter = 'A'; letter <= 'Z'; letter++){
            alphabet.add(letter);
        }

        for(char letter = 'a'; letter <= 'z'; letter++){
            alphabet.add(letter);
        }

        System.out.println("Bienvenido al juego del Ahorcado! ");
        System.out.println("Tienes 6 errores posibles! ");
        System.out.println("Inicio! ");
        game.printWord();
        System.out.println();
        while(game.checkForWin() == false && donChepe.checkForLose() == false){
            char move;

            //Check if the input is correct, else repeat
            do{
                System.out.print("Ingresa una letra: ");
                move = stdio.next().charAt(0);
            }while(!alphabet.contains(move));
            
            // Check the letter
            if(game.checkForWord(move) == true){
                System.out.println("Has encontrado la letra "+move+ "!");
            }else{
                System.out.println("La palabra no contiene "+move+ "!");
                donChepe.wrongAnswer();
            }

            donChepe.printHangMan(); //Print hangman
            game.printWord(); //Print word
            System.out.println();
        }
        stdio.close();
    }
}
