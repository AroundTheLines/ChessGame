package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Piece {
  
  private char color;
  private boolean inGame;
  
  public Piece(){} //no-arg constuctor to avoid stupid errors
  
  public Piece(char color) { 
    //Pre:
    //Post:
    this.color = color;
    this.inGame = true;
  }
  
  public char getColor() {
    //Pre:
    //Post:
    return this.color;
  }
  
  public boolean isPieceInGame() {
    //Pre:
    //Post:
    return this.inGame;}
  
  public void setPieceDead() {
    //Pre:
    //Post:
    this.inGame = false;}
  
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    //Pre:
    //Post:
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
    //Pre:
    //Post:
    
    Coordinate c = (Coordinate.subtract(c1, c2));
    String str = "Move is not in range. Try making a different move.";
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Pawn": 
        if (this.getColor() == 'W') {
          if (c.getXComponent() == 0) {
            if (c.getYComponent() == -2 && c1.getYComponent() == 6)
              return true;
            else if (c.getYComponent() == -1)
              return true;
            else {
              System.out.println(str);
              return false;
            }
          }
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == -1) {
            if (game_board.getPiece(c2).getColor() == 'B') {
              return true;
            }
            else {
              System.out.println(str);
              return false;
            }
          }
          else {
            System.out.println(str);
            return false;
          }
        }
        else {
          if (c.getXComponent() == 0) {
              if (c.getYComponent() == 2 && c1.getYComponent() == 1)
                return true;
              else if (c.getYComponent() == 1)
                return true;
              else {
                System.out.println(str);
                return false;
              }
          }
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == 1) {
            if (game_board.getPiece(c2).getColor() == 'W') {
              return true;
            }
            else {
              System.out.println(str);
              return false;
            }
          }
          else {
            System.out.println(str);
            return false;
          }
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
    //Pre:
    //Post:
    
    Coordinate c = (Coordinate.subtract(c1, c2));
    String str = "Move path is blocked. Try making a different move.";
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Knight":  
        return false;
        
      case "class com.chess_game.pieces.King":
        return false;
         
      case "class com.chess_game.pieces.Pawn":
        if (Math.abs(Coordinate.subtract(c1, c2).getXComponent()) == 1 && Math.abs(Coordinate.subtract(c1, c2).getYComponent()) == 1)
          return false;
        else if (this.getColor() == 'W' && com.chess_game.elements.Constants.game_board.getPiece(Coordinate.add(c1, new Coordinate(0, -1))).getClass() == com.chess_game.pieces.NullPiece.class)
          return false;
        else if (this.getColor() == 'B' && com.chess_game.elements.Constants.game_board.getPiece(Coordinate.add(c1, new Coordinate(0, 1))).getClass() == com.chess_game.pieces.NullPiece.class)
          return false;
        else {
          System.out.println(str);
          return true;
        }
        
      default:
        String direction = getDirection(c);
        
        switch (direction) {
          case "Up":
            for (int i = 0; i < Math.abs(c.getYComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(0, -1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
            
          case "Down":
            for (int i = 0; i < Math.abs(c.getYComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(0, 1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
            
          case "Right":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(1, 0))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
            
          case "Left":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(-1, 0))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
          
          case "UpRight":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(1, -1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
          
          case "DownRight":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(1, 1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
          
          case "UpLeft":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(-1, -1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
          
          case "DownLeft":
            for (int i = 0; i < Math.abs(c.getXComponent()); i++) {
              if (com.chess_game.elements.Constants.game_board.getBox(Coordinate.add(c1, new Coordinate(-1, 1))).getPiece().getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
            
          default:
            return false;
        }
    }
  }
  
  public boolean isTargetBlocked(Coordinate c2) {
    //Pre:
    //Post:
    try {
      if (this.getColor() == com.chess_game.elements.Constants.game_board.getBox(c2).getPiece().getColor()) {
        System.out.println("Target is blocked. Try making a different move.");
        return true;
      }
      else
        return false;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Move is not in range of the board");
      return false;//if the  array index is out of bounds, the target isn't blocked, it doesn't exist
    }
  }
  
  private static String getDirection(Coordinate c) {
    //Pre:
    //Post:
    int x, y;
    
    try {
    x = c.getXComponent()/Math.abs(c.getXComponent());
    } catch (ArithmeticException e) {
      x = 0;
    }
    
    try {
      y = c.getYComponent()/Math.abs(c.getYComponent());
    } catch (ArithmeticException e) {
      y = 0;
    }
    
    Coordinate d = new Coordinate(x, y);
    
    if (d.getXComponent() == 0){
      if (d.getYComponent() > 0)
        return "Down";
      else
        return "Up";
    }
      
    else if (d.getYComponent() == 0){
      if (d.getXComponent() > 0)
        return "Right";
      else
        return "Left";
    }
    
    else if (d.getXComponent() > 0) {
      if (d.getYComponent() > 0)
        return "DownRight";
      else
        return "UpRight";
    }
    
    else {
      if (d.getYComponent() > 0)
        return "DownLeft";
      else
        return "UpLeft";
    }
  }
  
  public String toString() {
    //Pre:
    //Post:
    return "piece type not specified";
  }
}
