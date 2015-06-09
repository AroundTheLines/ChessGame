package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Pawn extends Piece {
  
  public Pawn(char color) { 
    //Pre: None
    //Post: Creates Pawn Object
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "P";
  }
  
}
