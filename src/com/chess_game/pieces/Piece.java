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
//    System.out.println(isMoveInRange(c1, c2));//debug
    return isMoveInRange(c1, c2) && !isTargetBlocked(c2) && !isPathBlocked(c1, c2);
  }
  
  public boolean isMoveInRange(Coordinate c1, Coordinate c2) {
    
    Coordinate c = (Coordinate.substract(c1, c2));
    String str = "Move is not in range. Try making a different move.";
    Board game_board = com.chess_game.ChessGame.game_board;
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Pawn": 
        if (this.getColor() == 'W') {
          if (c.getXComponent() == 0) {
            if (c.getYComponent() == -2 && c1.getYComponent() == 6)
              return true;
            else if (c.getYComponent() == -1)
              return true;
            else
              return false;
          }
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == -1) {
            if (game_board.getPiece(c2).getColor() == 'B') {
              return true;
            }
            else
              return false;
          }
          else
            return false;
        }
        else {
          if (c.getXComponent() == 0) {
              if (c.getYComponent() == 2 && c1.getYComponent() == 1)
                return true;
              else if (c.getYComponent() == 1)
                return true;
              else
                return false;
          }
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == 1) {
            if (game_board.getPiece(c2).getColor() == 'W') {
              return true;
            }
            else
              return false;
          }
          else
            return false;
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
