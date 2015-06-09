package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Knight extends Piece {
  
  public Knight(char color) { 
    //Pre: None
    //Post: Creates Knight Object
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "N";
  }
  
}
