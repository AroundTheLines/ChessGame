/*
 * player 1 = white
 * player 2 = black
 */

package com.chess_game;

import com.chess_game.pieces.*;
import com.chess_game.elements.*;

import java.util.*;

public class ChessGame {
  public static HashMap<String, Piece> pieces = new HashMap<>();
  
  public static Board game_board;
  public static Board test_board;
  
  public static NullPiece n = new NullPiece();
  
  public static HashMap<Character, Integer> x_coord = new HashMap<Character, Integer>() {{
    put('a', 1);
    put('b', 2);
    put('c', 3);
    put('d', 4);
    put('e', 5);
    put('f', 6);
    put('g', 7);
    put('h', 8);
  }};
  
  public static void main(String[] args) {
    run();
  }
  
  public static void run() {
    addPieces();
    makeBoard();
    
    do {
      System.out.println(game_board);
      if (player1Turn()) {
        System.out.println(game_board);
        break;
      }
      
      System.out.println(game_board);
      if (player2Turn()) {
        System.out.println(game_board);
        break;
      }
    } while (true);
    
//    System.out.println(pieces);//debug
  }
  
  public static void addPieces() {
    //add kings
    pieces.put("white_king", new King('W'));
    pieces.put ("black_king", new King('B'));
    
    //add kings
    pieces.put("white_queen", new Queen('W'));
    pieces.put ("black_queen", new Queen('B'));
    
    //add rooks
    for (int i = 0; i < 2; i++)
      pieces.put("white_rook" + String.valueOf(i), new Rook('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_rook" + String.valueOf(i), new Rook('B'));
    
    //add knights 
    for (int i = 0; i < 2; i++)
      pieces.put("white_knight" + String.valueOf(i), new Knight('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_knight" + String.valueOf(i), new Knight('B'));
    
    //add bishops
    for (int i = 0; i < 2; i++)
      pieces.put("white_bishop" + String.valueOf(i), new Bishop('W'));
    for (int i = 0; i < 2; i++)
      pieces.put("black_bishop" + String.valueOf(i), new Bishop('B'));
    
    //add pawns
    for (int i = 0; i < 8; i++)
      pieces.put("white_pawn" + String.valueOf(i), new Pawn('W'));
    for (int i = 0; i < 8; i++)
      pieces.put("black_pawn" + String.valueOf(i), new Pawn('B'));
  }
  
  public static void makeBoard() {
    Box[][] b = new Box[8][8];
    
    String[] str = {"rook0", "knight0", "bishop0", "queen", "king", "bishop1", "knight1", "rook1"};
    
    for (int i = 0; i < 8; i++)
      b[7][i] = new Box(7, i, pieces.get("white_" + str[i]));
    
    for (int i = 0; i < 8; i++)
      b[0][i] = new Box(0, i, pieces.get("black_" + str[i]));
    
    for (int i = 0; i < 8; i++)
      b[6][i] = new Box(6, i, pieces.get("white_pawn" + String.valueOf(i)));
    
    for (int i = 0; i < 8; i++)
      b[1][i] = new Box(1, i, pieces.get("black_pawn" + String.valueOf(i)));
    
    for (int i = 2; i < 6; i++) {
      for (int j = 0; j < 8; j++)
        b[i][j] = new Box(i, j);
    }
    
    game_board = new Board(b);
  }
  
  public static boolean player1Turn() {
    try {
      Coordinate[] c;
      
      do {
        test_board = new Board(game_board);
        c = getMove(1);
        if (game_board.getBox(c[0]).getPiece().getColor() == 'W')
          test_board = game_board.makeHypoMove(c[0], c[1]);
      }
      
      while (test_board.getPiece(c[1]).getColor() != 'W' || !test_board.getPiece(c[1]).isMoveValid());
      
      game_board.getBox(c[1]).getPiece().setPieceDead();
      game_board = new Board(test_board);
      
      if (!pieces.get("black_king").isPieceInGame()) {
        System.out.println("Player 1 Wins");
        return true;
      }
      else
        return false;
    } catch (Exception e) {
      System.out.println("Move is invalid");
      return player1Turn();
    }
  }
  
  public static boolean player2Turn() {
   Coordinate[] c;
   
    do {
      test_board = new Board(game_board);
      c = getMove(2);
      if (game_board.getBox(c[0]).getPiece().getColor() == 'B')
        test_board = game_board.makeHypoMove(c[0], c[1]);
//      System.out.println(test_board);
    }
    while (test_board.getPiece(c[1]).getColor() != 'B' || !test_board.getPiece(c[1]).isMoveValid());
    
    game_board.getBox(c[1]).getPiece().setPieceDead();
    game_board = new Board(test_board);
    
    if (!pieces.get("white_king").isPieceInGame()) {
      System.out.println("Player 2 Wins");
      return true;
    }
    else
      return false;
  }
  
  public static Coordinate[] getMove(int i)
  {    
    String move = In.getString("\nPlayer " + String.valueOf(i) + ": Make Your Move: ");
    
    if (move.toLowerCase().equals("quit"))
      System.exit(0);
    else if (move.toLowerCase().equals("forfeit")) {
      System.out.println("Current player has forfeited");
      System.exit(0);
    }
    //else
    
    try {
      Coordinate[] c = {new Coordinate(x_coord.get(move.charAt(0)) - 1, 8 - Integer.parseInt(move.substring(1, 2))), 
        new Coordinate(x_coord.get(move.charAt(2)) - 1, 8 - Integer.parseInt(move.substring(3, 4)))};
      
      //System.out.println ("c[0] = " + c[0] + ", c[1] = " + c[1]);//debug
      return c;
      
    } catch (Exception e) {
      System.out.println("move is not in range");
      getMove(i);
    }
    
    return null;
  }
}
