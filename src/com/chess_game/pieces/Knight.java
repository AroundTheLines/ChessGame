package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Knight extends Piece {
  
  public Knight(char color) { 
    super(color);
  }
  
  @Override
  public String toString() {
    return getColor() + "N";
  }
  
}
