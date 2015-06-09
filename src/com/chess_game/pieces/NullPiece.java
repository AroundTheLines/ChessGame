/* Author(s) Asalan Andany and Qile Wang
 * 
 * Description:
 * A NullPiece occupies any box that is not occupied by any other piece
 * This makes checks and comparisons easier
 * This also helps avoid NullPointerExceptions
 */

package com.chess_game.pieces;

import com.chess_game.elements.Coordinate;

public class NullPiece extends com.chess_game.pieces.Piece {
  
  public NullPiece() { 
    //Pre: None
    //Post: Creates NullPiece
    
    super('n');
  }
  
  @Override
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    //Pre: None
    //Post: Will always return false b/c player shouldn't have any control over a NullPiece, let alone know about it
    
    return false;
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    
    return ".";
  }
  
}
