package com.chess_game;
import com.chess_game.pieces.*;
import com.chess_game.elements.*;

public class Tester {
  public static void main(String[] args) { 
    King k = new King('W');
    //isPiece();
    //System.out.println(String.valueOf(k));
    
    //testing printing
    Box[][] box = new Box[8][8];
    
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++)
        box[i][j] = new Box(false, i, j);
    }
    
    box[7][7] = new Box (true, 7, 7, k);
    Board test = new Board(box);
    System.out.println(test);
  }
  
  public static void isPiece (Piece p) {
    System.out.println(p.getClass().equals(King.class));
  }
}
