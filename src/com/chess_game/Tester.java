package com.chess_game;
import com.chess_game.pieces.*;
import com.chess_game.elements.*;

public class Tester {
  public static void main(String[] args) { 
    Piece p;
    King k = new King('W');
    p = k;
    isPiece(p);
    System.out.println(String.valueOf(p));
  }
  
  public static void isPiece (Piece p) {
    System.out.println(p.getClass().equals(King.class));
  }
}