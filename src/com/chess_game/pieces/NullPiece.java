package com.chess_game.pieces;
public class NullPiece extends com.chess_game.pieces.Piece {
  
  private char color;
  
  public NullPiece() { 
    color = 'n';
  }
  
  @Override
  public boolean isMoveValid() {
    return false;
  }
  @Override
  public String toString() {
    return ".";
  }
  
}
