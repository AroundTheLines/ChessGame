/* This class makes and does stuff with game_board 
 */

package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Board {
  private Box[][] board;
  
  public Board(Box[][] board) {
    //Pre: require a 2-dimensional array of Box Objects
    //Post: Creates an object of type board
    
    this.board = board;
  }
    
  public void makeMove(Coordinate from, Coordinate to){
    //Pre: Assuming Coordinates passed are correct
    //Post: Makes a move
    
    if (this.getPiece(from).getClass() == Pawn.class) {
      if (this.getPiece(from).getColor() == 'W' && to.getYComponent() == 0)
        Pawn.valueOf(this.getPiece(from)).promotePawn();
      else if (this.getPiece(from).getColor() == 'B' && to.getYComponent() == 7)
        Pawn.valueOf(this.getPiece(from)).promotePawn();
    }
    
    //the swap
    this.getBox(to).setPiece(this.getBox(from).getPiece());
    this.getBox(from).setBoxEmpty();
  }
  
  public Coordinate getPieceCoordinates(Piece p){
    //Pre: Piece must have a subtype (IE pawn, rook, queen, etc.)
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
    //Pre: Assumes coordinates are correct
    //Post: Returns a box with given coordinates
    
    return board[c.y][c.x];
  }
  
  public Piece getPiece(Coordinate c){
    //Pre: Assumes coordinates are correct
    //Post: returns a piece with given coordinates
    
    return board[c.y][c.x].getPiece();
  }
  
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    
    String printable = "";
    int i = 8;
    
    //adding the String value of each and every box in the board
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
