package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Queen extends Piece {
  
  public Queen(char color) { 
    super(color);
  }

  @Override
  public String toString() {
    return getColor() + "Q";
  }
  
}
