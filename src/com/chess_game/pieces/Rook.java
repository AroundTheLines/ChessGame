package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Rook extends Piece {
  
  public Rook(char color) { 
    super(color);
  }
    
  @Override
  public String toString() {
    return getColor() + "R";
  }
  
}
