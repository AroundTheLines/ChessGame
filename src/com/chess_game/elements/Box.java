package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean is_occupied = false;
 Coordinate coords;
 Piece piece;
 
 public Box(boolean isOccupied, char x, char y, Piece piece) {
  this.is_occupied = isOccupied;
  coords = new Coordinate(x,y);
  this.piece = piece;
 }
 
  public Box(boolean isOccupied, char x, char y) {
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
