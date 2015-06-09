package com.chess_game.pieces;
import com.chess_game.elements.*;

public class King extends Piece {
  
  public King(char color) { 
    //Pre:
    //Post:
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "K";
  }
}
