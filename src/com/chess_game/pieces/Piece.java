/* The superclass of all the pieces
 */

package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Piece {
  
  private char color;
  private boolean inGame;
  
  private Piece(){} //no-arg constuctor to avoid stupid errors
  
  public Piece(char color) { 
    //Pre: Character representing color (IE: 'W' for white, 'B' for black and 'n' for no color) passed in
    //Post: Makes the Piece object
    
    this.color = color;
    this.inGame = true;
  }
  
  public char getColor() {
    //Pre: None
    //Post: returns color of piece
    
    return this.color;
  }
  
  public boolean isPieceInGame() {
    //Pre: None
    //Post: return if the piece is alive as boolean
    
    return this.inGame;}
  
  public void setPieceDead() {
    //Pre: None
    //Post: kills the piece
    
    this.inGame = false;}
  
  public boolean isMoveValid(Coordinate c1, Coordinate c2) {
    //Pre: Coordinates must be correct
    //Post: returns if the move is valid as a boolean
    
    if (!isMoveInRange(c1, c2))
      return false;
    else if (isPathBlocked(c1, c2))
      return false;
    else if (isTargetBlocked(c2))
      return false;
    else
      return true;
  }
  
  private boolean isMoveInRange(Coordinate c1, Coordinate c2) {
    //Pre: Coordinates must be correct
    //Post: returns if the move is in range of piece as a boolean
    
    //using subtraction of coordinates, we can easily check if move is in range of piece
    Coordinate c = (Coordinate.subtract(c1, c2));
    String str = "Move is not in range. Try making a different move.";
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    switch (String.valueOf(this.getClass())) {
      //If the type of piece is pawn
      case "class com.chess_game.pieces.Pawn": 
        
        //if the color of the pawn is white
        if (this.getColor() == 'W') { 
        
          //if pawn doesn't move moves veertically
          if (c.getXComponent() == 0) {
            
            //if it's at it's starting position and moves up two, move is in range
            if (c.getYComponent() == -2 && c1.getYComponent() == 6) 
              return true;
            
            //if pawn only moves up one, its in its range regardless
            else if (c.getYComponent() == -1) 
              return true;
            
            //if the above two failed, the move isn't in range. this doesn't take into account impassante b/c idk exactly how that works
            else { 
              System.out.println(str);
              return false;
            }
          }
          //if pawn moves diagnally
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == -1) { 
            
            //if target contains a black piece, then move is in range
            if (game_board.getPiece(c2).getColor() == 'B') { 
              return true;
            }
            
            //otherwise you can't move diagnally and move isn't in range
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
        
        //otherwise if the piece is black
        else {
          //if pawn doesn't move moves veertically
          if (c.getXComponent() == 0) {
              //if it's at it's starting position and moves up two, move is in range
              if (c.getYComponent() == 2 && c1.getYComponent() == 1)
                return true;
              
              //if pawn only moves up one, its in its range regardless
              else if (c.getYComponent() == 1)
                return true;
              
              //if the above two failed, the move isn't in range. this doesn't take into account impassante b/c idk exactly how that works
              else {
                System.out.println(str);
                return false;
              }
          }
          
          //if the pawn moves diagonally
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == 1) {
            if (game_board.getPiece(c2).getColor() == 'W') {
              return true;
            }
            else {
              System.out.println(str);
              return false;
            }
          }
          
          //if all fails, the move isn't in the pawn's range
          else { 
            System.out.println(str);
            return false;
          }
        }
        
      //if the piece is a rook 
      case "class com.chess_game.pieces.Rook": 
        
        //if it moves horizontally or vertically, then the move is in range
        if (c.getXComponent() == 0 || c.getYComponent() == 0) 
          return true;
        
        //otherwise it's not
        else {
          System.out.println(str);
          return false;
        }
        
      //if the piece is a night
      case "class com.chess_game.pieces.Knight": 
        
        //if the knight moves in an 'L' shape
        if (Math.abs(c.getXComponent()) == 1 && Math.abs(c.getYComponent()) <= 2)
          return true;
        
        //or if it moves in an 'L' shape a slightly different way, the move is in range
        else if (Math.abs(c.getXComponent()) == 2 && Math.abs(c.getYComponent()) <= 1)
          return true;
        
        //otherwise it's not
        else {
          System.out.println(str);
          return false;
        }
        
      //if the piece is a bishop
      case "class com.chess_game.pieces.Bishop": 
        
        //if it moves diagonally, the move is in range
        if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent()))
          return true;
        
        //otherwise it's not
        else {
          System.out.println(str);
          return false;
        }
        
      //if the piece is a queen
      case "class com.chess_game.pieces.Queen": 
        
        //if it moves like a bishop, the move is in range
        if (c.getXComponent() == 0 || c.getYComponent() == 0) 
          return true;
        
        //if it moves like a rook, the move is in range
        else if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent())) 
          return true;
 
        //otherwise it's not
        else {
          System.out.println(str);
          return false;
        }
        
      //if the piece is a king
      case "class com.chess_game.pieces.King": 
        
        //if it moves within its 1 square radius, the move is in range
        if (Math.abs(c.getXComponent()) <= 1 && Math.abs(c.getYComponent()) <= 1)
          return true;
        
        //otherwise it's not
        else {
          System.out.println(str);
          return false;
        }
          
      //if the piece is a NullPiece
      default: 
        
        //the move isn't in range/isn't valid
        System.out.print(str);
        return false;
    }
  }
  
  private boolean isPathBlocked(Coordinate c1, Coordinate c2) {
    //Pre: assumes coordinates are correct
    //Post: return if the path to target is blocked as boolean
    
    Coordinate c = (Coordinate.subtract(c1, c2));
    String str = "Move path is blocked. Try making a different move.";
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    switch (String.valueOf(this.getClass())) {
      
      // if the piece is a knight
      case "class com.chess_game.pieces.Knight":
        return false;//nothing can block it
        
      // if the piece is a king
      case "class com.chess_game.pieces.King":
        return false;//nothing can block it
         
      //if the piece is a pawn
      case "class com.chess_game.pieces.Pawn": 
        //if the pawn is going 1 box diagonally
        if (Math.abs(Coordinate.subtract(c1, c2).getXComponent()) == 1 && Math.abs(Coordinate.subtract(c1, c2).getYComponent()) == 1)
          return false;//nothing can block it
        
        //if the pawn is going up 1 box and there is nothing in the target box
        else if (Math.abs(Coordinate.subtract(c1, c2).getYComponent()) == 1 && game_board.getPiece(c2).getColor() == 'n')
          return false;//nothing can block it
        
        //if the pawn is white and it's going 2 boxes up and there's only a NullPiece in between
        else if (this.getColor() == 'W' && game_board.getPiece(Coordinate.add(c1, new Coordinate(0, -1))).getClass() == com.chess_game.pieces.NullPiece.class)
          return false;//it's not being blocked
        
        //if the pawn is white and it's going 2 boxes down and there's only a NullPiece in between
        else if (this.getColor() == 'B' && game_board.getPiece(Coordinate.add(c1, new Coordinate(0, 1))).getClass() == com.chess_game.pieces.NullPiece.class)
          return false;//it's not being blocked
        
        //otherwise it's being blocked
        else {
          System.out.println(str);
          return true;
        }
        
      default: //if the piece is any other piece (ie queen, rook or bishop)
        String direction = getDirection(c);
        
        switch (direction) {
          
          //if the direction of the piece is upward
          case "Up":
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getYComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(0, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) {      
                System.out.println(str);
                return true;//it's being blocked
              }
            }
            return false;
            
          //if the direction of the piece is downward
          case "Down":
            
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getYComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(0, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
            
          //if the direction of the piece is rightward
          case "Right":
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, 0))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
            
          //if the direction of the piece is leftward
          case "Left":
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, 0))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
          
          //if the direction of the piece is uprightward
          case "UpRight":
            
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
            }
            return false;
          
          //if the direction of the piece is downrightward
          case "DownRight":
            
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
          
          //if the direction of the piece is upleftward
          case "UpLeft":
            
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
          
          //if the direction of the piece is downleftward
          case "DownLeft":
            
            //check all boxes between target and current position
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {
            
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
            }
            return false;
            
          default://safety measure
            return false;//then nothing blocking the piece
        }
    }
  }
  
  private boolean isTargetBlocked(Coordinate c2) {
    //Pre: Assuming coordinates are correct
    //Post: Returns if target position is blocked as boolean
    
      //if this pieces color is the same as the color of the piece in target
      if (this.getColor() == com.chess_game.elements.Constants.game_board.getBox(c2).getPiece().getColor()) {
        System.out.println("Target is blocked. Try making a different move.");//the target is blocked
        return true;
      }
      
      else
        return false;//otherwise it's not
  }
  
  private static String getDirection(Coordinate c) {
    //Pre: Assumes the coordinate subtracted (c2 - c1) is correct
    //Post: returns direction piece is/will be travelling in
    int x, y;
    
    //finds if the x component of subtracted coordinates is positive, zero, or negative
    try {
    x = c.getXComponent()/Math.abs(c.getXComponent());
    } catch (ArithmeticException e) {
      x = 0;
    }
    
    //finds if the y component of subtracted coordinates is positive, zero, or negative
    try {
      y = c.getYComponent()/Math.abs(c.getYComponent());
    } catch (ArithmeticException e) {
      y = 0;
    }
    
    Coordinate d = new Coordinate(x, y);
    
    //specific numbers relate to specific directions
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
    //Pre: None
    //Post: When objected printed, it's understandable by human
    
    return "piece type not specified";
  }
}
