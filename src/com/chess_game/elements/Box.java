/* Author(s) Asalan Andany and Qile Wang
 * Description: Makes and does stuff with each individual box within the board(game_board) 
 */

package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Box {
 private boolean is_occupied = false;
 private Coordinate coords;
 private Piece piece;
 
 public Box(int x, int y, Piece piece) {
   //Pre: Assumes arguments passed in are correct
   //Post: Creates an object of type Box with passed in piece occupying it
   
   this.is_occupied = true;
   coords = new Coordinate(x,y);
   this.piece = piece;
 }
 
 public Box(int x, int y) {
   //Pre: Assumes arguments passed in are correct
   //Post: Creates an object of type Box with NullPiece occupying it (however, this means the box isn't occupied)
   
   this.is_occupied = false;
   coords = new Coordinate(x,y);
   this.piece = com.chess_game.elements.Constants.n;
 }
 
 public Coordinate getCoordinates() {
   //Pre: Assumes box has coordinates
   //Post: returns coordinates of the box
   
   return coords;
 }
 
 public Piece getPiece() {
   //Pre: Assumes box has a piece
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
