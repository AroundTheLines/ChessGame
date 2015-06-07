package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Bishop extends Piece {
  
  public Bishop(char color) { 
    super(color);
  }
  
   public boolean isMoveValid() {
    if (isPlayerKingInCheck()) //if the move is made
      return false;
    else if (!isMoveInRange())
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
    return getColor() + "B";
  } 
}
