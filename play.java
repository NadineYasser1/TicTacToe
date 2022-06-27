/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nadineyasser
 */
public class play {
    public static void main(String[] args){
    
  GameBoard b = new GameBoard(6,7);
  b.initBoard();
  b.printBoard();
  do{if(b.checkWinner()) break;
  else{ System.out.println("player1's turn");
  b.enterPosition();
  b.changePlayer();
  b.printBoard();
  }
 if(b.checkWinner()) break;
 else{System.out.println("player2's turn");
  b.enterPosition();
  b.printBoard();
  b.changePlayer();}
  }while(!b.boardIsFull() && !b.checkWinner());
        System.out.println("Game Over!");
if(b.boardIsFull()) System.out.println("the game is a tie!");
  }

}
