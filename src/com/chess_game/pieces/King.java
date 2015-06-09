/* The King Class
 * Doesn't do much
 * Constructor + toString method
 */

package com.chess_game.pieces;
import com.chess_game.elements.*;

public class King extends Piece {
  
  public King(char color) { 
    //Pre: None
    //Post: Creates King Object
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "K";
  }
}
