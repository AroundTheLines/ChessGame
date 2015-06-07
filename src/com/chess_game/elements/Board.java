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
   Board copy = new Board(com.chess_game.ChessGame.game_board);
   copy.makeMove(from, to);
   return copy;
  }
  
  public void makeMove(Coordinate from, Coordinate to){
   Coordinate fromCoords = board[from.y][from.x].getCoordinates();
   board[to.y][to.x] = board[from.y][from.x];
   board[from.y][from.x] = new Box(false,fromCoords.x,fromCoords.y);
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
  
  public Box getBox(Coordinate z){
    return board[z.y][z.x];
  }
  
  public Piece getPiece(Coordinate z){
    return board[z.y][z.x].getPiece();
  }
  
  public String toString() {
    String printable = "";
    
    for (Box[] boxes : board) {
      
      for (Box box : boxes)
          printable += String.valueOf(box) + "\t";
      
      printable += "\n";
    }
    
    return printable;
  }
}
