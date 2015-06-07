package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean is_occupied = false;
 Coordinate coords;
 Piece piece;
 
 //just changed the x and y typing to int instead of char
 public Box(int x, int y, Piece piece) {
  this.is_occupied = true;
  coords = new Coordinate(x,y);
  this.piece = piece;
 }
 
 public Box(int x, int y) {
   this.is_occupied = false;
   coords = new Coordinate(x,y);
   this.piece = com.chess_game.ChessGame.n;
 }
 
 public Coordinate getCoordinates() {
  return coords;
 }
 
 public Piece getPiece() {
   return piece;
 }
 
 public void setPiece(Piece p) {
   this.piece = p;
   this.is_occupied = true;
 }
 
 public boolean isOccupied(){
   return is_occupied;
 }
  
 public void setBoxEmpty() {
   this.piece = com.chess_game.ChessGame.n;
   this.is_occupied = false;
 }
 
 public String toString() {
   return String.valueOf(piece);
 } 
}
