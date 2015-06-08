
/*TODO: 
 -initialize board array
 */
package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Board {
  
  private Box[][] board;
  
  public Board(){
    this.board  = new Box[8][8];
  }
  
  public Board(Box[][] board) {
    this.board = board;
  }
  
  //copy constructor
  public Board(Board another) {
    this.board = another.board;
  }
  
  public Board makeHypoMove(Coordinate from, Coordinate to){
   Board copy = new Board(this);
  
   copy.makeMove(from, to);
   
   return copy;
  }
  
  public void makeMove(Coordinate from, Coordinate to){
//    try {
      this.getBox(to).setPiece(this.getBox(from).getPiece());
      this.getBox(from).setBoxEmpty();
//    } catch (Exception e) {
//      System.out.println("Invalid move");
//    }
  }
  
  public void makeMove(Board another){
   this.board = another.board;
  }
  
  public Coordinate getPieceCoordinates(Piece p){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j].getPiece() == p){
          return board[i][j].getCoordinates();
        }
      }
    }
    return null;
  }
  
  public Box[][] getBoard() {
    return this.board;
  }
  
  public Box getBox(Coordinate c){
    return board[c.y][c.x];
  }
  
  public Piece getPiece(Coordinate c){
    return board[c.y][c.x].getPiece();
  }
  
  public String toString() {
    String printable = "";
    int i = 8;
    
    for (Box[] boxes : board) {
      printable += String.valueOf(i)+ "\t";
      
      for (Box box : boxes)
          printable += String.valueOf(box) + "\t";
      
      printable += "\n\n";
      i -= 1;
    }
    
    printable += "\ta\tb\tc\td\te\tf\tg\th\t";
    return printable;
  }
}
