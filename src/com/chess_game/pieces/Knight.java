package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Knight extends Piece {
  
  public Knight(char color) { 
    //Pre:
    //Post:
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "N";
  }
  
}
