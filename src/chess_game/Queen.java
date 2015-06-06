package chess_game;

public class Queen extends Piece {
  
  public Queen(char color) { 
    super(color);
  }
  
   public boolean isMoveValid() {
    if (isPlayerKingInCheck()) //if the move is made
      return false;
    else if (!isMoveInRange())
      return false;
    else if (isPathBlocked())
      return false;
    else
      return true;
  }
  
  public boolean isMoveInRange() {return true;}
  
  public boolean isPathBlocked() {return false;}
  
  public String toString() {
    return getColor() + "Q";
  }
  
}
