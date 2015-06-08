package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Pawn extends Piece {
  
  public Pawn(char color) { 
    super(color);
  }
  
//  @Override
//  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
////    if (this.getColor() == 'B' && com.chess_game.ChessGame.pieces.get("white_king").isPlayerKingInCheck()) //if move is made
////      return false;
////    else if (this.getColor() == 'W' && com.chess_game.ChessGame.pieces.get("black_king").isPlayerKingInCheck()) //if movie is made
////      return false;
//    if (!isMoveInRange(c1, c2))
//      return false;
//    else if (isPathBlocked(c1, c2))
//      return false;
//    else if (isTargetBlocked(c2))
//      return false;
//    else
//      return true;
//  }
//  
//  public boolean isMoveInRange(Coordinate c1, Coordinate c2) {return true;}
//  
//  public boolean isPathBlocked(Coordinate c1, Coordinate c2) {return false;}
  
  @Override
  public String toString() {
    return getColor() + "P";
  }
  
}
