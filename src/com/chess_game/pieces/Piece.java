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
  
  public boolean isPlayerKingInCheck() {
    if (isKnightChecking())
      return true;
    else if (isQueenChecking())
      return true;
    else if (isRookChecking())
      return true;
    else if (isBishopChecking())
      return true;
    else if (isPawnChecking())
      return true;
    else if (isKingChecking())
      return true;
    else
      return false;
  }
  
  private boolean isKnightChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    
    Coordinate[] array_of_coordinates = new Coordinate[8];
    
    array_of_coordinates[0] = new Coordinate(-1, 2);
    array_of_coordinates[1] = new Coordinate(1, 2);
    array_of_coordinates[2] = new Coordinate(-1, -2);
    array_of_coordinates[3] = new Coordinate(1, -2);
    
    array_of_coordinates[4] = new Coordinate(-2, 1);
    array_of_coordinates[5] = new Coordinate(2, 1);
    array_of_coordinates[6] = new Coordinate(-2, -1);
    array_of_coordinates[7] = new Coordinate(2, -1);
    
    for (Coordinate t : array_of_coordinates)
    {
      try {
        if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
          if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Knight.class)) {
            if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor())
              return true;
          }
        }
      } catch(Exception e) {}
    }
    /*if loop falls through*/ return false;
  }
  
  private boolean isQueenChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    Coordinate t = c;
    
    Coordinate[] array_of_coordinates = new Coordinate[8];
    
    array_of_coordinates[0] = new Coordinate(0, 1);
    array_of_coordinates[1] = new Coordinate(0, -1);
    array_of_coordinates[2] = new Coordinate(1, 0);
    array_of_coordinates[3] = new Coordinate(-1, 0);
    
    array_of_coordinates[4] = new Coordinate(1, 1);
    array_of_coordinates[5] = new Coordinate(-1, -1);
    array_of_coordinates[6] = new Coordinate(1, -1);
    array_of_coordinates[7] = new Coordinate(-1, 1);
    
    for (Coordinate s : array_of_coordinates) {
      try {
        while (true) {
          t = Coordinate.add(t, s);
          
          if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
            if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor()) {
              break; //if broken, then no queen in current direction checking
            }
            if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Queen.class))
              return true;
            else
              break; //if exception caught, then no queen in current direction checking
          }
        }
      } catch (Exception e) {} //if exception caught, then no queen in current direction checking 
      
      t=c;//resetting t for next iteration
    }
    
    /*loop falls through*/ return false;
  }
  
  private boolean isRookChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    Coordinate t = c;
    
    Coordinate[] array_of_coordinates = new Coordinate[8];
    
    array_of_coordinates[0] = new Coordinate(0, 1);
    array_of_coordinates[1] = new Coordinate(0, -1);
    array_of_coordinates[2] = new Coordinate(1, 0);
    array_of_coordinates[3] = new Coordinate(-1, 0);
    
    for (Coordinate s : array_of_coordinates) {
      try {
        while (true) {
          t = Coordinate.add(t, s);
          
          if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
            if (Board.getPiece(Coordinate.add(c, t)).getColor()!= this.getColor()) {
              break; //if broken, then no queen in current direction checking
            }
            if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Queen.class))
              return true;
            else
              break; //if exception caught, then no queen in current direction checking
          }
        }
      } catch (Exception e) {} //if exception caught, then no queen in current direction checking
      
      t=c;//resetting t for next iteration
    }
    
    /*loop falls through*/ return false;
  }
  
  private boolean isBishopChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    Coordinate t = c;
    
    Coordinate[] array_of_coordinates = new Coordinate[8];
    
    array_of_coordinates[4] = new Coordinate(1, 1);
    array_of_coordinates[5] = new Coordinate(-1, -1);
    array_of_coordinates[6] = new Coordinate(1, -1);
    array_of_coordinates[7] = new Coordinate(-1, 1);
    
    for (Coordinate s : array_of_coordinates) {
      try {
        while (true) {
          t = Coordinate.add(t, s);
          
          if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
            if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor()) {
              break; //if broken, then no queen in current direction checking
            }
            if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Queen.class))
              return true;
            else
              break; //if exception caught, then no queen in current direction checking
          }
        }
      } catch (Exception e) {} //if exception caught, then no queen in current direction checking
      
      t=c;//resetting t for next iteration
    }
    
    /*loop falls through*/ return false;
  }
  
  private boolean isPawnChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    
    Coordinate t = new Coordinate(1, 1);
    if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
      if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Pawn.class)) {
        if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor())
          return true;
      }
    }
    
    t = new Coordinate(-1, 1);
    if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
      if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Pawn.class)) {
        if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor())
          return true;
      }
    }
    
    /*if nothing returned yet, by default*/return false;
  }
  
  private boolean isKingChecking() {
    Coordinate c = Board.getPieceCoordinates(this);
    
    Coordinate[] array_of_coordinates = new Coordinate[8];
    
    array_of_coordinates[0] = new Coordinate(1, 1);
    array_of_coordinates[2] = new Coordinate(0, 1);
    array_of_coordinates[1] = new Coordinate(-1, 1);
    
    array_of_coordinates[3] = new Coordinate(1, 0);
    array_of_coordinates[4] = new Coordinate(-1, 0);
    
    array_of_coordinates[5] = new Coordinate(1, -1);
    array_of_coordinates[6] = new Coordinate(0, -1);
    array_of_coordinates[7] = new Coordinate(-1, -1);
    
    for (Coordinate t : array_of_coordinates)
    {
      if (Board.getBox(Coordinate.add(c, t)).isOccupied() == true) {
        if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Knight.class)) {
          if (Board.getPiece(Coordinate.add(c, t)).getColor() != this.getColor())
            return true;
        }
      }
    }
    /*if loop falls through*/ return false;
  }
  
  public String toString() {
    return "piece type not specified";
  }
  
  public Board makeHypoMove(Coordinate from, Coordinate to){
	  Board copy = com.chess_game.ChessGame.game_board;
	  copy.makeMove(from, to);
	  return copy;
  }
}
