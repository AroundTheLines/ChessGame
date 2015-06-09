/* The Bishop Class
 * Doesn't do much
 * Constructor + toString method
 */

package com.chess_game.pieces;
import com.chess_game.elements.*;

public class Bishop extends Piece {
  
  public Bishop(char color) {
    //Pre: None
    //Post: Creates Bishop object
    super(color);
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "B";
  } 
}
