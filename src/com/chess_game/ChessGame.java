/*
 * player 1 = white
 * player 2 = black
 */

package com.chess_game;

import com.chess_game.pieces.*;
import com.chess_game.elements.*;

import java.util.HashMap;

public class ChessGame {
  public static HashMap<String, Piece> pieces = new HashMap<>();
  
  public static void main(String[] args) {
    //add kings
    pieces.put("white_king", new King('W'));
    pieces.put ("black_king", new King('B'));
    
    //add kings
    pieces.put("white_queen", new Queen('W'));
    pieces.put ("black_queen", new Queen('B'));
    
    //add rooks
    for (int i = 0; i < 2; i++)
      pieces.put("white_rook" + String.valueOf(i), new Rook('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_rook" + String.valueOf(i), new Rook('B'));
    
    //add knights 
    for (int i = 0; i < 2; i++)
      pieces.put("white_knight" + String.valueOf(i), new Knight('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_knight" + String.valueOf(i), new Knight('B'));
    
    //add bishops
    for (int i = 0; i < 2; i++)
      pieces.put("white_bishop" + String.valueOf(i), new Bishop('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_bishop" + String.valueOf(i), new Bishop('B'));
    
    //add pawns
    for (int i = 0; i < 8; i++)
      pieces.put("white_pawn" + String.valueOf(i), new Pawn('W'));
    for (int i = 0; i < 8; i++)
      pieces.put("black_pawn" + String.valueOf(i), new Pawn('B'));
  }
}
