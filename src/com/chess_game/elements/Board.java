package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Board {
  private Box[][] board;
  
  public Board(Box[][] board) {
    //Pre: None
    //Post: Creates an object of type board
    this.board = board;
  }
    
  public void makeMove(Coordinate from, Coordinate to){
    //Pre: Assuming arguments passed are correct
    //Post: Makes a move
      this.getBox(to).setPiece(this.getBox(from).getPiece());
      this.getBox(from).setBoxEmpty();
  }
  
  public Coordinate getPieceCoordinates(Piece p){
    //Pre: None
    //Post: Returns any piece's coordinates on the board
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
    //Pre: None
    //Post: Returns a box with given coordinates
    return board[c.y][c.x];
  }
  
  public Piece getPiece(Coordinate c){
    //Pre: None
    //Post: returns a piece with given coordinates
    return board[c.y][c.x].getPiece();
  }
  
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
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
