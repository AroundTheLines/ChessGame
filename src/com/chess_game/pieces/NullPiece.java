package com.chess_game.pieces;

import com.chess_game.elements.Coordinate;

public class NullPiece extends com.chess_game.pieces.Piece {
  
  private char color;
  
  public NullPiece() { 
    //Pre:
    //Post:
    color = 'n';
  }
  
  @Override
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    //Pre:
    //Post:
    return false;
  }
  
  @Override
  public String toString() {
    //Pre:
    //Post:
    return ".";
  }
  
}
