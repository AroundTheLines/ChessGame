/* Makes and does stuff with each individual box within the board(game_board) 
 */

package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 boolean is_occupied = false;
 Coordinate coords;
 Piece piece;
 
 public Box(int x, int y, Piece piece) {
   //Pre: None
   //Post: Creates an object of type Box with passed in piece occupying it
   this.is_occupied = true;
   coords = new Coordinate(x,y);
   this.piece = piece;
 }
 
 public Box(int x, int y) {
   //Pre: None
   //Post: Creates an object of type Box with NullPiece occupying it (however, this means the box isn't occupied)
   this.is_occupied = false;
   coords = new Coordinate(x,y);
   this.piece = com.chess_game.elements.Constants.n;
 }
 
 public Coordinate getCoordinates() {
   //Pre: None
   //Post: returns coordinates of the box
   return coords;
 }
 
 public Piece getPiece() {
   //Pre: None
   //Post: Returns piece occupying the box (including NullPiece)
   return piece;
 }
 
 public void setPiece(Piece p) {
   //Pre: None
   //Post: Sets piece to occupy box
   this.piece = p;
   this.is_occupied = true;
 }
 
 public boolean isOccupied(){
   //Pre: None
   //Post: Returns a boolean refering to whether the box is occupied (if NullPiece occupies the box, this would return false)
   return is_occupied;
 }
  
 public void setBoxEmpty() {
   //Pre: None
   //Post: sets is_occupied to false and sets NullPiece as piece ocuupying box
   this.piece = com.chess_game.elements.Constants.n;
   this.is_occupied = false;
 }
 
 public String toString() {
   //Pre: None
   //Post: When objected printed, it's understandable by human
   return String.valueOf(piece);
 } 
}
