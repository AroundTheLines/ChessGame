package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Queen extends Piece {
  
  public Queen(char color) { 
    //Pre: None
    //Post: Creates Queen Object
    super(color);
  }

  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "Q";
  }
  
}
