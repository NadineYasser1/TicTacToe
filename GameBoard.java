import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nadineyasser
 */
public class GameBoard {
  private  int rows;
  private  int columns;
  public  char[][] GameBoard;
  private  boolean player1=true;
  
   public  GameBoard(int rows,int columns){ //constructor for GameBoard
      
   this.rows = rows;
  this.columns = columns;
    GameBoard= new char[rows][columns];

 
      
  }
   public void initBoard(){   //initializing all characters in GameBoard to be ' '
       for(int i=0;i<GameBoard.length;i++){
            for(int j=0;j<GameBoard[i].length;j++){
               GameBoard[i][j]=' '; 
            }
   }
   }
  
    public void printBoard() { 
        printColumnSeparator();
        for(int i=0;i<GameBoard.length;i++){
            for(int j=0;j<GameBoard[i].length;j++){
                System.out.print("|"+GameBoard[i][j]);
            }
            System.out.print("|");
            System.out.println();
            printColumnSeparator();
        }
        
    }


private void printColumnSeparator() {

    for (int x=0; x<GameBoard[0].length; x++)

        System.out.print("--");
        System.out.println("-");

}
public void changePlayer(){
    player1=!player1;
}
public void enterPosition(){ 
    int x;
    int y;
    boolean f=false;
    Scanner in = new Scanner(System.in); //used scanner to scan position from user

 
    do{
    System.out.println("please enter the row number:");
    x=in.nextInt();
     System.out.println("please enter the column number:");
    y=in.nextInt();
    if(GameBoard[x][y]!=' ') System.out.println("invalid selection! position is occupied,"
            + "please enter another one."); //we notify the user if the position is occupied
    else if(x<0 || y<0 || x>rows || y>columns) System.out.println("Position is out of bounds"
            + "please enter a valid position."); //we notify the user if the position is outside the gameboard
    else{
        if(player1) GameBoard[x][y]='X'; // 'X' is for player1
        else GameBoard[x][y]='O'; // 'O' is for player2
       f=true;
    }
}while(f=false);
    
}

private char playerHasWon() {
    char winner = ' ';
		//checking each row
		for(int i = 0; i < GameBoard.length; i++) {
                    for(int j=0;j<(GameBoard[i].length)-2;j++){
	   if(GameBoard[i][j] == GameBoard[i][j+1] && GameBoard[i][j+1] == GameBoard[i][j+2] && GameBoard[i][j] != ' ') {
				winner = GameBoard[i][j];
                                break;
           }
                    }
                }
             //checking each column
		for(int i = 0; i < (GameBoard.length)-2; i++) {
                    for(int j=0;j<GameBoard[i].length;j++){
			if(GameBoard[i][j] == GameBoard[i+1][j] && GameBoard[i+1][j] == GameBoard[i+2][j] && GameBoard[i][j] != ' ') {
				winner = GameBoard[i][j];
                                break;

			}
		}
                }
                //checking each diagonal
                for(int i = 0; i < (GameBoard.length)-2; i++) {
                    for(int j=0;j<(GameBoard[i].length)-2;j++){
		if(GameBoard[i][j] == GameBoard[i+1][j+1] && GameBoard[i+1][j+1] == GameBoard[i+2][j+2] && GameBoard[i][j] != ' ') {
                               winner = GameBoard[i][j];
                        break;

		}
                    }
                }
	

		
		return winner;

	}

public boolean boardIsFull() { //checking if all positions are full then the game is a tie
		for(int i = 0; i < GameBoard.length; i++) {
			for(int j = 0; j <GameBoard[i].length; j++) {
				if(GameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

public boolean checkWinner(){
     char winner;
     winner = playerHasWon();//the method playerHasWon() returns the symbol(X/O) that has filled 3 positions in a row
    boolean f = false;
    if(winner=='X') { //if the winner is X then player1 has won
      f=true;
        System.out.println("Player1 Has Won!");

        
    }
    else if(winner=='O') { //if the winner is O then player2 has won
       f=true;
        System.out.println("Player2 Has Won!");
        
        
    }
  return f;

}

}




