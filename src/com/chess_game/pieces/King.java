package com.chess_game.pieces;
import com.chess_game.elements.*;

public class King extends Piece {
  
  public King(char color) { 
    super(color);
  }
  
  @Override
  public boolean isMoveValid() {
//    if (this.isPlayerKingInCheck()) //if move is made
//      return false;
    if (!isMoveInRange())
      return false;
    else if (isPathBlocked())
      return false;
    else
      return true;
  }
  
  public boolean isMoveInRange() {return true;}
  
  public boolean isPathBlocked() {return false;}
  
  @Override
  public String toString() {
    return getColor() + "K";
  }
}
