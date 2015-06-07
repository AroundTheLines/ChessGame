package com.chess_game;
import com.chess_game.pieces.*;
import com.chess_game.elements.*;

public class Tester {
  public static void main(String[] args) { 
    King k = new King('W');
    //isPiece();
    System.out.println(String.valueOf(k));
  }
  
  public static void isPiece (Piece p) {
    System.out.println(p.getClass().equals(King.class));
  }
}
