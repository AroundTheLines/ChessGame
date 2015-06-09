package com.chess_game.elements;

import com.chess_game.pieces.*;
import java.util.*;

public class Constants {
  public static HashMap<String, Piece> pieces = new HashMap<>();
  
  public static Board game_board;
  
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
}