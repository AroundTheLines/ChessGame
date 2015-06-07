package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Knight extends Piece {
  
  public Knight(char color) { 
    super(color);
  }
  
  @Override
  public boolean isMoveValid() {
//    if (this.getColor() == 'B' && com.chess_game.ChessGame.pieces.get("white_king").isPlayerKingInCheck()) //if move is made
//      return false;
//    else if (this.getColor() == 'W' && com.chess_game.ChessGame.pieces.get("black_king").isPlayerKingInCheck()) //if movie is made
//      return false;
    if (!isMoveInRange())
      return false;
    else if (isTargetBlocked())
      return false;
    else
      return true;
  }
  
  public boolean isMoveInRange() {return true;}
  
  public boolean isTargetBlocked() {return false;}
  
  @Override
  public String toString() {
    return getColor() + "N";
  }
  
}
