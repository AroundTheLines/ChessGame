package com.chess_game.pieces;

import com.chess_game.elements.Coordinate;

public class NullPiece extends com.chess_game.pieces.Piece {
  
  private char color;
  
  public NullPiece() { 
    color = 'n';
  }
  
//  public boolean isMoveValid() {
//    return false;
//  }
  
  @Override
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    return false;
  }
  
  @Override
  public String toString() {
    return ".";
  }
  
}
