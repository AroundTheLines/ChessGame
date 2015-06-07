/*TODO: 
 -initialize board array
 */
package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Board {
  
  static Box[][] board = new Box[8][8];
  
  public Board(){
    
  }
  
  public static Coordinate getPieceCoordinates(Piece p){
    for(int i = 0; i< board.length; i++){
      for(int j = 0; j<board[i].length;j++){
        if(board[i][j].getPiece() == p){
          return board[i][j].getCoordinates();
        }
      }
    }
    return null;
  }
  
  public static Box getBox(Coordinate z){
    return board[z.y][z.x];
  }
  
  public static Piece getPiece(Coordinate z){
    return board[z.y][z.x].getPiece();
  }
  
  public String toString() {
    String printable = "";
    
    for (Box[] boxes : board) {
      for (Box box : boxes) {
        if (box.getPiece() != null)
          printable += String.valueOf(box) + "/t";
        else       
          printable += "./t";
      }
      printable += "/n";
    }
    
    return printable;
  }
}
