package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean isOccupied = false;
 Coordinate coords;
 Piece piece;
 
 public Box(boolean isOccupied, char x, char y, Piece piece) {
  this.isOccupied = isOccupied;
  coords = new Coordinate(x,y);
  this.piece = piece;
 }
 
  public Box(boolean isOccupied, char x, char y) {
  this.isOccupied = isOccupied;
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
}
