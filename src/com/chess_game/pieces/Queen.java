package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Queen extends Piece {
  
  public Queen(char color) { 
    super(color);
  }
  
   public boolean isMoveValid() {
    if (this.getColor() == 'B' && com.chess_game.ChessGame.pieces.get("white_king").isPlayerKingInCheck()) //if move is made
      return false;
    else if (this.getColor() == 'W' && com.chess_game.ChessGame.pieces.get("black_king").isPlayerKingInCheck()) //if movie is made
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
    return getColor() + "Q";
  }
  
}
