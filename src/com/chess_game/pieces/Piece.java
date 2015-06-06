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
  
  public String getColor() {
    return String.valueOf(color);
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
      if (Board.getPiece(Coordinate.add(c, t)).getClass().equals(Knight.class)) {
        if (!Board.getPiece(Coordinate.add(c, t)).getColor().equals(this.getColor()))
          return true;
      }
    }
    /*else if loop falls through*/ return false;
  }
  
  private boolean isQueenChecking() {
    
    return false;//dummy code
  }

  private boolean isRookChecking() {
    
    return false;//dummy code
  }
  
  private boolean isBishopChecking() {
    
    return false;//dummy code
  }
  
  private boolean isPawnChecking() {
    
    return false;//dummy code
  }
  
  private boolean isKingChecking() {
    
    return false;//dummy code
  }
}