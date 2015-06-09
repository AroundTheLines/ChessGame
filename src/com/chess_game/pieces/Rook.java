package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Rook extends Piece {
  
  public Rook(char color) { 
    //Pre:
    //Post:
    super(color);
  }
    
  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "R";
  }
  
}
