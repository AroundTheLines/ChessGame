package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Pawn extends Piece {
  
  public Pawn(char color) { 
    //Pre:
    //Post:
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "P";
  }
  
}
