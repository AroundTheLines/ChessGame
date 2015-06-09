/* this class exists for the sole purpose of maing ChessGame.java cleaner
 */

package com.chess_game.elements;

import com.chess_game.pieces.*;
import java.util.*;

public class Constants {
  public static HashMap<String, Piece> pieces = new HashMap<>();//initiallizes hashmap
  
  public static Board game_board;//initializes the game board
  
  public static NullPiece n = new NullPiece();//NullPiece to make life easier
  
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
    com.chess_game.elements.Constants.pieces.put("white_king", new King('W'));
    com.chess_game.elements.Constants.pieces.put ("black_king", new King('B'));
    
    //make kings
    com.chess_game.elements.Constants.pieces.put("white_queen", new Queen('W'));
    com.chess_game.elements.Constants.pieces.put ("black_queen", new Queen('B'));
    
    //make rooks
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_rook" + String.valueOf(i), new Rook('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_rook" + String.valueOf(i), new Rook('B'));
    
    //make knights 
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_knight" + String.valueOf(i), new Knight('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_knight" + String.valueOf(i), new Knight('B'));
    
    //make bishops
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("white_bishop" + String.valueOf(i), new Bishop('W'));
    for (int i = 0; i < 2; i++)
      com.chess_game.elements.Constants.pieces.put("black_bishop" + String.valueOf(i), new Bishop('B'));
    
    //make pawns
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

}
