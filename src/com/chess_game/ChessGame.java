/* Chess game played in this class
 * This is the class with the main method
 * 
 * player 1 = white
 * player 2 = black
 */

package com.chess_game;

import com.chess_game.pieces.*;
import com.chess_game.elements.*;

import java.util.*;

public class ChessGame {
  
  public static boolean isGameDone = false;
  
  public static void main(String[] args) {
    //Pre: None
    //Post: Runs the game
    
    //makes the pieces neccessary for the game
    com.chess_game.elements.Constants.makePieces();
    
    //makes the board, with the pieces contained on the board
    com.chess_game.elements.Constants.makeBoard();
    
    do {
      System.out.println(com.chess_game.elements.Constants.game_board);
      
      player1Turn();
      if (isGameDone) {
        System.out.println(com.chess_game.elements.Constants.game_board);
        break;
      }
      
      System.out.println(com.chess_game.elements.Constants.game_board);
      
      player2Turn();
      if (isGameDone) {
        System.out.println(com.chess_game.elements.Constants.game_board);
        break;
      }
    } while (true);
    
  }
    
  public static void player1Turn() {
    //Pre: None
    //Post: Executes white's turn
    
    //copies the instance of game_board from Constants.java
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    try {
      Coordinate[] c;
      Boolean b = true;
      
      do {
        //gets move
        c = getMove(1);
        
        //first part of condition checks if selection of piece is the same color as the player
        //second part of condition checks if user desired mover is valid
        if (game_board.getPiece(c[0]).getColor() == 'W' && game_board.getPiece(c[0]).isMoveValid(c[0], c[1])) {
          b = false;
          
          //kills piece at the target
          game_board.getBox(c[1]).getPiece().setPieceDead();
          
          //makes move
          game_board.makeMove(c[0], c[1]);
        }
        else
          System.out.println("That is not your piece. Try making a different move.");
        
      } while (b);//keep doing above until user makes valid move
      
      
      //checks if king is dead
      if (!com.chess_game.elements.Constants.pieces.get("black_king").isPieceInGame()) {
        System.out.println("Player 1 Wins");
        isGameDone = true;
      }
      
    } catch (ArrayIndexOutOfBoundsException e) {
      //if the user enters a move which would lead the piece off the board
      System.out.println("Move is out of range of board");
      player1Turn();
    }
  }
  
  
  //mostly same to player1Turn with some adjustments
  public static void player2Turn() {
    //Pre: None
    //Post: Execute black's turn
    
    //copies the instance of game_board from Constants.java
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    try {
      Coordinate[] c;
      Boolean b = true;
      
      do {
        //gets move
        c = getMove(2);
        
        
        //first part of condition checks if selection of piece is the same color as the player
        //second part of condition checks if user desired mover is valid
        if (game_board.getPiece(c[0]).getColor() == 'B' && game_board.getPiece(c[0]).isMoveValid(c[0], c[1])) {
          b = false;
          
          //kills piece at the target
          game_board.getBox(c[1]).getPiece().setPieceDead();
          
          //makes move
          game_board.makeMove(c[0], c[1]);
        }
      } while (b);
      
      //checks if king is dead
      if (!com.chess_game.elements.Constants.pieces.get("white_king").isPieceInGame()) {
        System.out.println("Player 2 Wins");
        isGameDone = true;
      }
      
    } catch (ArrayIndexOutOfBoundsException e) {
      //if the user enters a move which would lead the piece off the board
      System.out.println("Move is out of range of board");
      player2Turn();
    }
  }
  
  public static Coordinate[] getMove(int i) {    
    //Pre: assumes i refers to current player number
    //Post: returns the move the player wishes to make as coordinate array
    
    //user input of move
    String move = In.getString("\nPlayer " + String.valueOf(i) + ": Make Your Move: ");
    move = move.toLowerCase();
    
    if (move.equals("quit"))
      System.exit(0);
    else if (move.equals("forfeit")) {
      System.out.println("Current player has forfeited");
      System.out.println("Player " + 2/i + " wins");
      System.exit(0);
    }
    else if (move.equals("rules")) {
      //open rules
    }
    
    Coordinate[] c = new Coordinate[2];
    
    try {
      //turns user input into coordinates we, programmers, can work with, and stores it in an array
      c[0] = new Coordinate(com.chess_game.elements.Constants.x_coord.get(move.charAt(0)) - 1, 8 - Integer.parseInt(move.substring(1, 2))); 
      c[1] = new Coordinate(com.chess_game.elements.Constants.x_coord.get(move.charAt(2)) - 1, 8 - Integer.parseInt(move.substring(3, 4)));
      
    } catch (NullPointerException e) {
      System.out.println("That is an invalid move. Enter the move in the correct format please.");
      c = getMove(i);
      
    } finally {    
      return c;
    }
  }
}
