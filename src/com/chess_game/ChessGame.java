/*
 * player 1 = white
 * player 2 = black
 */

package com.chess_game;

import com.chess_game.pieces.*;
import com.chess_game.elements.*;

import java.util.*;

public class ChessGame {
  public static void main(String[] args) {
    run();
  }
  
  public static void run() {
    //Pre:
    //Post:
    addPieces();
    makeBoard();
    
    do {
      System.out.println(com.chess_game.elements.Constants.game_board);
      if (player1Turn()) {
        System.out.println(com.chess_game.elements.Constants.game_board);
        break;
      }
      
      System.out.println(com.chess_game.elements.Constants.game_board);
      if (player2Turn()) {
        System.out.println(com.chess_game.elements.Constants.game_board);
        break;
      }
    } while (true);
    
  }
  
  public static void addPieces() {
    //Pre: None
    //Post: Creates all pieces for the game
    
    //add kings
    com.chess_game.elements.Constants.pieces.put("white_king", new King('W'));
    com.chess_game.elements.Constants.pieces.put ("black_king", new King('B'));
    
    //add kings
    com.chess_game.elements.Constants.pieces.put("white_queen", new Queen('W'));
    com.chess_game.elements.Constants.pieces.put ("black_queen", new Queen('B'));
    
    //add rooks
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_rook" + String.valueOf(i), new Rook('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_rook" + String.valueOf(i), new Rook('B'));
    
    //add knights 
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_knight" + String.valueOf(i), new Knight('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_knight" + String.valueOf(i), new Knight('B'));
    
    //add bishops
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_bishop" + String.valueOf(i), new Bishop('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_bishop" + String.valueOf(i), new Bishop('B'));
    
    //add pawns
    for (int i = 0; i < 8; i++)
      com.chess_game.elements.Constants.pieces.put("white_pawn" + String.valueOf(i), new Pawn('W'));
    for (int i = 0; i < 8; i++)
      com.chess_game.elements.Constants.pieces.put("black_pawn" + String.valueOf(i), new Pawn('B'));
  }
  
  public static void makeBoard() {
    //Pre: None
    //Post: Makes the actual game board
    Box[][] b = new Box[8][8];
    
    String[] str = {"rook0", "knight0", "bishop0", "queen", "king", "bishop1", "knight1", "rook1"};
    
    for (int i = 0; i < 8; i++)
      b[7][i] = new Box(7, i, com.chess_game.elements.Constants.pieces.get("white_" + str[i]));
    
    for (int i = 0; i < 8; i++)
      b[0][i] = new Box(0, i, com.chess_game.elements.Constants.pieces.get("black_" + str[i]));
    
    for (int i = 0; i < 8; i++)
      b[6][i] = new Box(6, i, com.chess_game.elements.Constants.pieces.get("white_pawn" + String.valueOf(i)));
    
    for (int i = 0; i < 8; i++)
      b[1][i] = new Box(1, i, com.chess_game.elements.Constants.pieces.get("black_pawn" + String.valueOf(i)));
    
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++)
        b[i][j] = new Box(i, j);
    }
    
    com.chess_game.elements.Constants.game_board = new Board(b);
  }
  
  public static boolean player1Turn() {
    //Pre: None
    //Post: Executes white's turn
    
    try {
      Coordinate[] c;
      Boolean b = true;
      
      do {
        c = getMove(1);//gets move
        
        //first part of condition checks if selection of piece is the same color as the player. will make this more gracefull when the program actually works
        //second part of condition checks if user desired mover is valid
        if (com.chess_game.elements.Constants.game_board.getPiece(c[0]).getColor() == 'W' && com.chess_game.elements.Constants.game_board.getPiece(c[0]).isMoveValid(c[0], c[1])) {
          b = false;
          com.chess_game.elements.Constants.game_board.getBox(c[1]).getPiece().setPieceDead();//kills piece at the target
          com.chess_game.elements.Constants.game_board.makeMove(c[0], c[1]);//makes move
        }
      } while (b);//keep doing above until user makes valid move
      
      
      //checks if king is dead
      if (!com.chess_game.elements.Constants.pieces.get("black_king").isPieceInGame()) {
        System.out.println("Player 1 Wins");
        return true;
      }
      else
        return false;
    } catch (ArrayIndexOutOfBoundsException e) {
      //only supposed to be caught if user enters desired move/target that does not exist on the board
      System.out.println("Move is out of range of board");
      e.printStackTrace();
      return player1Turn();
    }
  }
  
  
  //mostly same to player1Turn with some adjustments
  public static boolean player2Turn() {
    //Pre: None
    //Post: Execute black's turn
    try {
      Coordinate[] c;
      Boolean b = true;
      
      do {
        c = getMove(2);
        
        if (com.chess_game.elements.Constants.game_board.getPiece(c[0]).getColor() == 'B' && com.chess_game.elements.Constants.game_board.getPiece(c[0]).isMoveValid(c[0], c[1])) {
          b = false;
          com.chess_game.elements.Constants.game_board.getBox(c[1]).getPiece().setPieceDead();
          com.chess_game.elements.Constants.game_board.makeMove(c[0], c[1]);
        }
      } while (b);
      
      if (!com.chess_game.elements.Constants.pieces.get("white_king").isPieceInGame()) {
        System.out.println("Player 2 Wins");
        return true;
      }
      else
        return false;
      
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Move is out of range of board");
      e.printStackTrace();
      return player2Turn();
    }
  }
  
  public static Coordinate[] getMove(int i) {    
    //Pre: assumes i refers to current player number
    //Post: returns the move the player wishes to make as coordinate array
    String move = In.getString("\nPlayer " + String.valueOf(i) + ": Make Your Move: ");//user input of move
    
    if (move.toLowerCase().equals("quit"))
      System.exit(0);
    else if (move.toLowerCase().equals("forfeit")) {
      System.out.println("Current player has forfeited");
      System.out.println("Player " + 2/i + " wins");
      System.exit(0);//change to end without killing
    }
    //else
    
    //turns user input into coordinates we, programmers, can work with, and stores it in an array
    Coordinate[] c = {new Coordinate(com.chess_game.elements.Constants.x_coord.get(move.charAt(0)) - 1, 8 - Integer.parseInt(move.substring(1, 2))), 
      new Coordinate(com.chess_game.elements.Constants.x_coord.get(move.charAt(2)) - 1, 8 - Integer.parseInt(move.substring(3, 4)))};
    
    return c;
  }
}
