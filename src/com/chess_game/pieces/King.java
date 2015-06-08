package com.chess_game.pieces;
import com.chess_game.elements.*;

public class King extends Piece {
  
  public King(char color) { 
    super(color);
  }
  
  @Override
  public String toString() {
    return getColor() + "K";
  }
}
