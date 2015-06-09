package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Queen extends Piece {
  
  public Queen(char color) { 
    //Pre:
    //Post:
    super(color);
  }

  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "Q";
  }
  
}
