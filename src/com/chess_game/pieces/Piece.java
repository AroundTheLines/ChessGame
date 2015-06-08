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
//    System.out.println("debug, " + String.valueOf(this.getClass()));
    
//    System.out.println(this.getClass());
    Coordinate c = (Coordinate.substract(c1, c2));
    String str = "Move is not in range. Try making a different move.";
    Board game_board = com.chess_game.ChessGame.game_board;
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Pawn": 
        if (Math.abs(c.getXComponent()) == 1 && Math.abs(c.getYComponent()) == 1) {
        if (game_board.getPiece(Coordinate.add(game_board.getPieceCoordinates(this), c)).getColor() != this.getColor())
          System.out.println("debug");
      }
        
      case "class com.chess_game.pieces.Rook":     
        if (c.getXComponent() == 0 || c.getYComponent() == 0)
          return true;
        else {
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Knight": 
        if (Math.abs(c.getXComponent()) == 1 && Math.abs(c.getYComponent()) <= 2)
          return true;
        else if (Math.abs(c.getXComponent()) == 2 && Math.abs(c.getYComponent()) <= 1)
          return true;
        else {
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Bishop": 
        if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent()))
          return true;
        else {
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Queen": 
        if (c.getXComponent() == 0 || c.getYComponent() == 0)
          return true;
        else if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent()))
          return true;
        else {
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.King": 
        if (Math.abs(c.getXComponent()) <= 1 && Math.abs(c.getYComponent()) <= 1)
          return true;
        else {
          System.out.println(str);
          return false;
        }
          
      default: 
        System.out.print(str);
        return false;
    }
  }
  
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
