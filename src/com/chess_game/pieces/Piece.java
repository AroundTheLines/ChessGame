package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Piece {
  
  private char color;
  private boolean inGame;
  
  public Piece(){} //no-arg constuctor to avoid stupid errors
  
  public Piece(char color) { 
    this.color = color;
    this.inGame = true;
  }
  
  public char getColor() {
    return this.color;
  }
  
  public boolean isPieceInGame() {return this.inGame;}
  
  public void setPieceDead() {this.inGame = false;}
  
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    if (!isMoveInRange(c1, c2))
      return false;
    else if (isPathBlocked(c1, c2))
      return false;
    else if (isTargetBlocked(c2))
      return false;
    else
      return true;
  }
  
  public boolean isMoveInRange(Coordinate c1, Coordinate c2) {
    //coordinates components of (current position - target position) must have same mmagnitude
    return true;}
  
  public boolean isPathBlocked(Coordinate c1, Coordinate c2) {
    
    return false;}
  
  public boolean isTargetBlocked(Coordinate c2) {
    try {
      if (this.getColor() == com.chess_game.ChessGame.game_board.getBox(c2).getPiece().getColor()) {
        System.out.println("Target is blocked. Try a different move.");
        return true;
      }
      else
        return false;
    } catch (ArrayIndexOutOfBoundsException e) {
      return false;//if the  array index is out of bounds, the target isn't blocked, it doesn't exist
    }
  }
  
  public String toString() {
    return "piece type not specified";
  }
}
