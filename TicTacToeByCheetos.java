import java.util.Scanner;
import java.lang.Math;

// We define a simple pair
class IntPair{
    int first;
    int second;
}

// Class grid
class Grid{
    // Attributes
    private int size;
    private char grid [][];

    // Constructor O(n^2)
    Grid(int n){
        this.size = n;
        this.grid = new char[this.size][this.size];
        for(int i=0; i<this.size; i++)
            for(int j=0; j<this.size; j++)
                this.grid[i][j] = ' ';
    }

    // Getters
    int getSize(){return this.size;}
    char getStatus(int i, int j){return this.grid[i][j];}

    // Check fot valid move
    public boolean isValid(int i, int j){
        if(getStatus(i,j) != ' ')
            return false;
        return true;

    }

    // Make a move (Method for player interaction with the grid)
    public boolean makeMove(int i, int j, char c){
        if(!isValid(i,j))
            return false;
        this.grid[i][j] = c;
        return true;
    }

    // Check if the game is over
    public boolean isGameOver(int movesA, int movesB, String nameA, String nameB){
        char a = 'O', b = 'X';
        
        //  Necessary moves to check if the game is over
        if(movesA < this.size)
            return false;
        
        // O won?
        if(winningState(a)){
            System.out.println("El jugador "+ nameA +" es el ganador (O)");
            return true;
        }

        // X won?
        if(winningState(b)){
            System.out.println("El jugador "+ nameB +" es el ganador (X)");
            return true;
        }

        //If no one won, and moves are greater than possible moves, it's a tie
        if(movesA + movesB > this.size*this.size){
            System.out.println("Empate!");
            return true;
        }
        return false;
    }


    //Check if the game is on winning state, O(n^2)
    public boolean winningState(char p){
        boolean isWon =  true;
        //Check rows
        for(int i = 0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                if(this.grid[i][j] != p){
                    isWon = false;
                    break;
                }
                if(j == this.size-1){
                    isWon = true;
                    break;
                }
            }
            if(isWon == true) break; 
        }
        
        if(isWon == true)
            return true;

        //Check columns
        for(int i = 0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                if(this.grid[j][i] != p){
                    isWon = false;
                    break;
                }
                if(j == this.size-1){
                    isWon = true;
                    break;
                }
            }
            if(isWon == true) break;
        }

        if(isWon == true)
            return true;

        // Check principal diagonal
        isWon = true; 
        for (int i = 0; i < this.size; i++) {
            if (this.grid[i][i] != p) {
                isWon = false; 
                break;
            }
        }

        if(isWon == true)
            return true;

        // Check secondary diagonal
        isWon = true;
        for (int i = 0; i < this.size; i++) {
            if (this.grid[i][this.size - i - 1] != p) {
                isWon = false; 
                break;
            }
        }

        return isWon;
    }

    //Show the grid O(n^2)
    public void printGrid(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                System.out.print("|" + this.grid[i][j]);
            }
            System.out.println("|");
        }
        System.out.println();
    }

    // Clear the grid for a new match O(n^2)
    public void clearGrid(){
        for(int i=0; i<this.size; i++)
            for(int j=0; j<this.size; j++)
                this.grid[i][j] = ' ';
    }
}

// Class player
class Player{
    //Attributes
    private String name = new String();
    private char side = ' ';
    private int moves = 0;

    //Constructor
    Player(String name, char side){
        this.name = name;
        this.side = side;
    }

    //Getters
    public String getName(){return this.name;}
    public char getSide(){return this.side;}
    public int getMoves(){return this.moves;}

    //Move setter
    public void setMoves(int m){this.moves = m;}

    //Generate a random move
    public IntPair playerTurn(int gridSize){
        IntPair move = new IntPair();
        int max = gridSize-1;
        int min = 0;
        int range = max - min + 1;
        int x =(int)(Math.random() * range) + min;
        int y =(int)(Math.random() * range) + min;

        move.first = x;
        move.second = y;
        
        return move;
    }
}

// Main class
public class TicTacToeByCheetos{
    // Program pause function (Pressing Enter generates a line feed character (LF) or a carriage return character (CR), or both, depending on the operating system.)
    public static void pressEnterToContinue(){ 
        System.out.println("Pulsa enter para continuar...");
        try{
            System.in.read();
        }catch(Exception e){}
    }
    public static void main(String [] args){
        Scanner cout = new Scanner(System.in);
        int n = 5;
        // Initialize objects
        Grid board = new Grid(n);
        System.out.println("Ingrese el nombre del jugador 1 (O): ");
        String name = cout.nextLine();
        Player player1 = new Player(name, 'O');
        System.out.println("Ingrese el nombre del jugador 2 (X): ");
        String name2 = cout.nextLine();
        Player player2 = new Player(name2, 'X');
        boolean play = true;
        // Play
        while(play){
            board.clearGrid();
            boolean isValidMove = false;
            int movesA = 0;
            int movesB = 1;
            for(int i=1; i<=n*n; i++){            
                System.out.println("Turno "+ i +"  del jugador "+player1.getName());
                IntPair move;

                //Check for a valid move O(2^n) because the last check is a repeat permutation
                do{
                    move = player1.playerTurn(n);
                    isValidMove = board.makeMove(move.first, move.second, player1.getSide());
                }while(!isValidMove);

                // Sum moves and set it to the player
                movesA +=1;
                player1.setMoves(movesA);
                board.printGrid();

                //Check if the game is over
                if(board.isGameOver(player1.getMoves(),player2.getMoves(),player1.getName(),player2.getName()))
                    break;
                
                pressEnterToContinue(); //Pause
                
                System.out.println("Turno "+ i +"  del jugador "+player2.getName());

                //Check for a valid move O(2^n) because the last check is a repeat permutation                
                do{
                    move = player2.playerTurn(n);
                    isValidMove = board.makeMove(move.first, move.second,player2.getSide());
                }while(!isValidMove);
                movesB +=1;
                player2.setMoves(movesB);
                board.printGrid();

                //Check if the game is over
                if(board.isGameOver(player1.getMoves(),player2.getMoves(),player1.getName(),player2.getName()))
                    break;
                pressEnterToContinue();
            }

            System.out.println("Deseas jugar otra vez?");
            System.out.println("1: Si ---- 2: No");
            int again = cout.nextInt();
            cout.nextLine();

            if(again == 1)
                play = true;
            else
                play = false;
        }
        System.out.println("Gracias por jugar! :D");
        cout.close();
    }   
}