package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Piece {
  
  private char color;
  private boolean inGame;
  
  public Piece(){} //no-arg constuctor to avoid stupid errors
  
  public Piece(char color) { 
    //Pre: None
    //Post:Makes the Piece object
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
  
  public boolean isMoveInRange(Coordinate c1, Coordinate c2) {
    //Pre: Coordinates must be correct
    //Post: returns if the move is in range of piece as a boolean
    
    Coordinate c = (Coordinate.subtract(c1, c2));//using subtraction of coordinates, we can easily check if move is in range of piece
    String str = "Move is not in range. Try making a different move.";
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Pawn": //If the type of piece is pawn
        if (this.getColor() == 'W') { //if the color of the pawn is white
          if (c.getXComponent() == 0) {//if pawn doesn't move diag
            if (c.getYComponent() == -2 && c1.getYComponent() == 6) //if it's at it's starting position and moves up two, move is in range
              return true;
            else if (c.getYComponent() == -1) //if pawn only moves up one, its in its range regardless
              return true;
            else { //if the above two failed, the move isn't in range. this doesn't take into account impassante b/c idk exactly how that works
              System.out.println(str);
              return false;
            }
          }
          else if (Math.abs(c.getXComponent()) == 1 && c.getYComponent() == -1) { //if pawn moves diagnally
            if (game_board.getPiece(c2).getColor() == 'B') { //if target contains a black piece, then move is in range
              return true;
            }
            else { //otherwise you can't move diagnolly and move isn't in range
              System.out.println(str);
              return false;
            }
          }
          else {
            System.out.println(str);
            return false;
          }
        }
        else { //otherwise if the piece is black
          //same stuff for if the piece is white, except tweaked a little to make it work, structure is same
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
          else { //if all fails, the move isn't in the pawn's range
            System.out.println(str);
            return false;
          }
        }
        
      case "class com.chess_game.pieces.Rook": //if the piece is a rook 
        //if it moves horizontally or vertically, then the move is in range
        if (c.getXComponent() == 0 || c.getYComponent() == 0) 
          return true;
        else {//otherwise it's not
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Knight": //if the piece is a night
        //if the knight moves in an 'L' shape
        if (Math.abs(c.getXComponent()) == 1 && Math.abs(c.getYComponent()) <= 2)
          return true;
        //or if it moves in an 'L' shape a slightly different way, the move is in range
        else if (Math.abs(c.getXComponent()) == 2 && Math.abs(c.getYComponent()) <= 1)
          return true;
        else {//otherwise it's not
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Bishop": //if the piece is a bishop
        //if it moves diagonally, the move is in range
        if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent()))
          return true;
        else {//otherwise it's not
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.Queen": //if the piece is a queen
        if (c.getXComponent() == 0 || c.getYComponent() == 0) //if it moves like a bishop
          return true;
        else if (Math.abs(c.getXComponent()) == Math.abs(c.getYComponent())) //or like a rook, the move is in range
          return true;
        else {//otherwise it's not
          System.out.println(str);
          return false;
        }
        
      case "class com.chess_game.pieces.King": //if the piece is a king
        //if it moves within its 1 square radius, the move is in range
        if (Math.abs(c.getXComponent()) <= 1 && Math.abs(c.getYComponent()) <= 1)
          return true;
        else {//otherwise it's not
          System.out.println(str);
          return false;
        }
          
      default: //if the piece is a NullPiece
        System.out.print(str);
        return false;//the move isn't in range/isn't valid
    }
  }
  
  public boolean isPathBlocked(Coordinate c1, Coordinate c2) {
    //Pre: assumes coordinates are correct
    //Post: return if the path to target is blocked as boolean
    
    Coordinate c = (Coordinate.subtract(c1, c2));
    String str = "Move path is blocked. Try making a different move.";
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    switch (String.valueOf(this.getClass())) {
      case "class com.chess_game.pieces.Knight":// if the piece is a knight
        return false;//nothing can block it
        
      case "class com.chess_game.pieces.King":// if the piece is a king
        return false;//nothing can block it
         
      case "class com.chess_game.pieces.Pawn": //if the piece is a pawn
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
        
        else {//otherwise it's being blocked
          System.out.println(str);
          return true;
        }
        
      default: //if the piece is any other piece
        String direction = getDirection(c);
        
        switch (direction) {
          case "Up"://if the direction of the piece is upward
            for (int i = 1; i < Math.abs(c.getYComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(0, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) {      
                System.out.println(str);
                return true;//it's being blocked
              }
              else
                return false;
            }
            
          case "Down"://if the direction of the piece is downward
            for (int i = 1; i < Math.abs(c.getYComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(0, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
            
          case "Right"://if the direction of the piece is rightward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, 0))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
            
          case "Left"://if the direction of the piece is leftward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, 0))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
          
          case "UpRight"://if the direction of the piece is uprightward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) {
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
          
          case "DownRight"://if the direction of the piece is downrightward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(i, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
          
          case "UpLeft"://if the direction of the piece is upleftward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, -1 * i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
          
          case "DownLeft"://if the direction of the piece is downleftward
            for (int i = 1; i < Math.abs(c.getXComponent()); i++) {//check all boxes between target and current position
              //if there's anything but a null piece in between
              if (game_board.getPiece(Coordinate.add(c1, new Coordinate(-1 * i, i))).getClass() != com.chess_game.pieces.NullPiece.class) { 
                System.out.println(str);
                return true;
              }
              else
                return false;
            }
            
          default://safety measure
            return false;//then nothing blocking the piece
        }
    }
  }
  
  public boolean isTargetBlocked(Coordinate c2) {
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
