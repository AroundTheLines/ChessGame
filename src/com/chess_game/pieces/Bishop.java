package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Bishop extends Piece {
  
  public Bishop(char color) { 
    super(color);
  }
  
  @Override
  public String toString() {
    return getColor() + "B";
  } 
}
