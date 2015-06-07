package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean is_occupied = false;
 Coordinate coords;
 Piece piece;
 //just changed the x and y typing to int instead of char
 public Box(boolean isOccupied, int x, int y, Piece piece) {
  this.is_occupied = isOccupied;
  coords = new Coordinate(x,y);
  this.piece = piece;
 }
 
  public Box(boolean isOccupied, int x, int y) {
  this.is_occupied = isOccupied;
  coords = new Coordinate(x,y);
  this.piece = null;
 }
 
 public Coordinate getCoordinates() {
  return coords;
 }
 
 public Piece getPiece() {
  return piece;
 }
 
 public String toString() {
   return String.valueOf(piece);
 } 
 
 public boolean isOccupied(){
	 return is_occupied;
 }
}
