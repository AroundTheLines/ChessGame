package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Board {
  private Box[][] board;
  
  public Board(Box[][] board) {
    //Pre:
    //Post:
    this.board = board;
  }
    
  public void makeMove(Coordinate from, Coordinate to){
    //Pre:
    //Post:
      this.getBox(to).setPiece(this.getBox(from).getPiece());
      this.getBox(from).setBoxEmpty();
  }
  
  public Coordinate getPieceCoordinates(Piece p){
    //Pre:
    //Post:
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j].getPiece() == p){
          return board[i][j].getCoordinates();
        }
      }
    }
    return null;
  }
  
  public Box getBox(Coordinate c){
    //Pre:
    //Post:
    return board[c.y][c.x];
  }
  
  public Piece getPiece(Coordinate c){
    //Pre:
    //Post:
    return board[c.y][c.x].getPiece();
  }
  
  public String toString() {
    //Pre:
    //Post:
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
