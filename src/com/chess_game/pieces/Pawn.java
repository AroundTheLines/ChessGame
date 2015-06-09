package com.chess_game.pieces;
import com.chess_game.elements.*;
import com.chess_game.In;

import java.util.HashMap;

public class Pawn extends Piece {
  
  public Pawn(char color) { 
    //Pre: None
    //Post: Creates Pawn Object
    super(color);
  }
  
  public void promotePawn() {
    HashMap<String, Piece> pieces = com.chess_game.elements.Constants.pieces;
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    char choice = In.getChar("Welcome to the PAWN PROMTION PORTAL\nEnter \'Q\' to promote to Queen" + 
                             "\nEnter \'R\' to promote to Rook\nEnter \'N\' to promote to Knight" +
                             "\nEnter \'B\' to promote to Bishop\n");
    
    choice = Character.toUpperCase(choice);
    int i = 1;
    
    switch((int)choice) {
      case (int)'Q':
        while(pieces.get("queen" + String.valueOf(i)) != null)
          i++;
        pieces.put("queen" + String.valueOf(i), new Queen(this.getColor()));        
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("queen" + String.valueOf(i)));
        return;
        
      case (int)'R':
        while(pieces.get("rook" + String.valueOf(i)) != null)
          i++;
        pieces.put("rook" + String.valueOf(i), new Rook(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("rook" + String.valueOf(i)));
        return;
        
      case (int)'N':
        while(pieces.get("knight" + String.valueOf(i)) != null)
          i++;
        pieces.put("knight" + String.valueOf(i), new Knight(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("knight" + String.valueOf(i)));
        return;
        
      case (int)'B':
        while(pieces.get("bishop" + String.valueOf(i)) != null)
          i++;
        pieces.put("bishop" + String.valueOf(i), new Bishop(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("bishop" + String.valueOf(i)));
        return;
        
      default:
        System.out.println("Invalid choice. Please choose again");
        this.promotePawn();
    }
  }
  
  public static Pawn valueOf(Piece piece) {
    return (Pawn)piece;
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    return getColor() + "P";
  }
  
}
