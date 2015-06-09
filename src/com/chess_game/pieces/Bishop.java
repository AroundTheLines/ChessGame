package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Bishop extends Piece {
  
  public Bishop(char color) {
    //Pre:
    //Post:
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre:
    //Post:
    return getColor() + "B";
  } 
}
