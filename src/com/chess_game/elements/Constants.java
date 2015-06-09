/* Author(s) Asalan Andany and Qile Wang
 * 
 * Description:
 * This class exists for the sole purpose of maing ChessGame.java cleaner
 * This class stores and creates constants used throoughout the program
 */

package com.chess_game.elements;

import com.chess_game.pieces.*;
import java.util.*;

public class Constants {
  //initiallizes hashmap
  public static HashMap<String, Piece> pieces = new HashMap<>();
  
  //initializes the game board
  public static Board game_board;
  
  //NullPiece to make life easier
  public static NullPiece n = new NullPiece();
  
  //another hashmap to aid with the making of object of type coordinates Coordinates
  public static HashMap<Character, Integer> x_coord = new HashMap<Character, Integer>() {{
    put('a', 1);
    put('b', 2);
    put('c', 3);
    put('d', 4);
    put('e', 5);
    put('f', 6);
    put('g', 7);
    put('h', 8);
  }};
  
  public static void makePieces() {
    //Pre: None
    //Post: Creates all pieces for the game
    
    //make kings
    pieces.put("white_king", new King('W'));
    pieces.put ("black_king", new King('B'));
    
    //make queens
    pieces.put("white_queen", new Queen('W'));
    pieces.put ("black_queen", new Queen('B'));
    
    //make rooks
    for (int i = 0; i < 2; i++)
      pieces.put("white_rook" + String.valueOf(i), new Rook('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_rook" + String.valueOf(i), new Rook('B'));
    
    //make knights 
    for (int i = 0; i < 2; i++)
      pieces.put("white_knight" + String.valueOf(i), new Knight('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_knight" + String.valueOf(i), new Knight('B'));
    
    //make bishops
    for (int i = 0; i < 2; i++)
      pieces.put("white_bishop" + String.valueOf(i), new Bishop('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_bishop" + String.valueOf(i), new Bishop('B'));
    
    //make pawns
    for (int i = 0; i < 8; i++)
      pieces.put("white_pawn" + String.valueOf(i), new Pawn('W'));
    for (int i = 0; i < 8; i++)
      pieces.put("black_pawn" + String.valueOf(i), new Pawn('B'));
  }
  
  public static void makeBoard() {
    //Pre: None
    //Post: Makes the game board
    
    Box[][] b = new Box[8][8];
    
    String[] str = {"rook0", "knight0", "bishop0", "queen", "king", "bishop1", "knight1", "rook1"};
    
    //places all white pieces, excluding pawns, on the board
    for (int i = 0; i < 8; i++)
      b[7][i] = new Box(7, i, pieces.get("white_" + str[i]));
    
    //places all black pieces, excluding pawns, on the boar
    for (int i = 0; i < 8; i++)
      b[0][i] = new Box(0, i, pieces.get("black_" + str[i]));
    
    //places all white pawns on the board
    for (int i = 0; i < 8; i++)
      b[6][i] = new Box(6, i, pieces.get("white_pawn" + String.valueOf(i)));
    
    //places all black pawns on the board
    for (int i = 0; i < 8; i++)
      b[1][i] = new Box(1, i, pieces.get("black_pawn" + String.valueOf(i)));
    
    //fills the rest of the board with NullPieces
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++)
        b[i][j] = new Box(i, j);
    }
    
    game_board = new Board(b);
  }

}
