package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean is_occupied = false;
 Coordinate coords;
 Piece piece;
 
 public Box(int x, int y, Piece piece) {
   //Pre:
   //Post:
   this.is_occupied = true;
   coords = new Coordinate(x,y);
   this.piece = piece;
 }
 
 public Box(int x, int y) {
   //Pre:
   //Post:
   this.is_occupied = false;
   coords = new Coordinate(x,y);
   this.piece = com.chess_game.elements.Constants.n;
 }
 
 public Coordinate getCoordinates() {
   //Pre:
   //Post:
   return coords;
 }
 
 public Piece getPiece() {
   //Pre:
   //Post:
   return piece;
 }
 
 public void setPiece(Piece p) {
   //Pre:
   //Post:
   this.piece = p;
   this.is_occupied = true;
 }
 
 public boolean isOccupied(){
   //Pre:
   //Post:
   return is_occupied;
 }
  
 public void setBoxEmpty() {
   //Pre:
   //Post:
   this.piece = com.chess_game.elements.Constants.n;
   this.is_occupied = false;
 }
 
 public String toString() {
   //Pre:
   //Post:
   return String.valueOf(piece);
 } 
}
