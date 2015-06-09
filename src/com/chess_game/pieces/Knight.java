/* Author(s) Asalan Andany and Qile Wang
 * 
 * Description:
 * The Knight Class
 * Doesn't do much
 * Constructor + toString method
 */

package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Knight extends Piece {
  
  public Knight(char color) { 
    //Pre: Character representing color (IE: 'W' for white, 'B' for black and 'n' for no color) passed in
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
