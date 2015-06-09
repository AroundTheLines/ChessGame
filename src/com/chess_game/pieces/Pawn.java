/* The Pawn Class
 */

package com.chess_game.pieces;
import com.chess_game.elements.*;
import com.chess_game.In;

import java.util.HashMap;

public class Pawn extends Piece {
  
  public Pawn(char color) { 
    //Pre: Character representing color (IE: 'W' for white, 'B' for black and 'n' for no color) passed in
    //Post: Creates Pawn Object
    
    super(color);
  }
  
  public void promotePawn() {
    //Pre: Only called when pawn reaches end of the chess board
    //Post: Promotes pawn when the pawn reaches other end of board
    
    HashMap<String, Piece> pieces = com.chess_game.elements.Constants.pieces;
    Board game_board = com.chess_game.elements.Constants.game_board;
    
    char choice = In.getChar("Welcome to the PAWN PROMTION PORTAL\nEnter \'Q\' to promote to Queen" + 
                             "\nEnter \'R\' to promote to Rook\nEnter \'N\' to promote to Knight" +
                             "\nEnter \'B\' to promote to Bishop\n");
    
    choice = Character.toUpperCase(choice);
    int i = 1;
    
    switch((int)choice) {
      //if the player chooses to promote to queen
      case (int)'Q':
        //replace the pawn with a queen of the same color
        while(pieces.get("queen" + String.valueOf(i)) != null)
          i++;
        pieces.put("queen" + String.valueOf(i), new Queen(this.getColor()));        
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("queen" + String.valueOf(i)));
        return;
        
      //if the player chooses to promote to rook
      case (int)'R':
        //replace the pawn with a rook of the same color
        while(pieces.get("rook" + String.valueOf(i)) != null)
          i++;
        pieces.put("rook" + String.valueOf(i), new Rook(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("rook" + String.valueOf(i)));
        return;
      
      //if the player chooses to promote to knight
      case (int)'N':
        //replace the pawn with a rook of the same color
        while(pieces.get("knight" + String.valueOf(i)) != null)
          i++;
        pieces.put("knight" + String.valueOf(i), new Knight(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("knight" + String.valueOf(i)));
        return;
        
      //if the player chooses to promote to bishop
      case (int)'B':
        //replace the pawn with a rook of the same color
        while(pieces.get("bishop" + String.valueOf(i)) != null)
          i++;
        pieces.put("bishop" + String.valueOf(i), new Bishop(this.getColor()));
        game_board.getBox(game_board.getPieceCoordinates(this)).setPiece(pieces.get("bishop" + String.valueOf(i)));
        return;
        
      //if the player picks an non-existent choice
      default:
        System.out.println("Invalid choice. Please choose again");
        this.promotePawn();
    }
  }
  
  public static Pawn valueOf(Piece piece) {
    //Pre: Called only on a Piece of type Pawn
    //Post: Casts the Piece as a Pawn
    
    return (Pawn)piece;
  }
  
  @Override
  public String toString() {
    //Pre: None
    //Post: When objected printed, it's understandable by human
    
    return getColor() + "P";
  }
  
}
