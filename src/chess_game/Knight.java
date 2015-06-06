package chess_game;

public class Knight extends Piece {
  
  public Knight(char color) { 
    super(color);
  }
  
   public boolean isMoveValid() {
    if (isPlayerKingInCheck()) //if the move is made
      return false;
    else if (!isMoveInRange())
      return false;
    else if (isTargetBlocked())
      return false;
    else
      return true;
  }
  
   public boolean isMoveInRange() {return true;}
  
  public boolean isTargetBlocked() {return false;}
  
  public String toString() {
    return getColor() + "N";
  }
  
}
