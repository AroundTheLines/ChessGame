public class Piece {
  
  private char color;
  private boolean inGame;
  
  public Piece(){} //no-arg constuctor to avoid stupid errors
  
  public Piece(char color) { 
    this.color = color;
    this.inGame = true;
  }
  
  public String getColor() {
    return String.valueOf(color);
  }
  
  public boolean isPieceInGame() {return this.inGame;}
  
  public void setPieceDead() {this.inGame = false;}
  
  public boolean isPlayerKingInCheck() {
    if (isKnightChecking())
      return true;
    else if (isQueenChecking())
      return true;
    else if (isRookChecking())
      return true;
    else if (isBishopChecking())
      return true;
    else if (isPawnChecking())
      return true;
    else if (isKingChecking())
      return true;
    else
      return false;
  }
  
  private boolean isKnightChecking() {
    //Coor
    return false;//dummmmy code
  }
  
  private boolean isQueenChecking() {
    
    return false;//dummy code
  }

  private boolean isRookChecking() {
    
    return false;//dummy code
  }
  
  private boolean isBishopChecking() {
    
    return false;//dummy code
  }
  
  private boolean isPawnChecking() {
    
    return false;//dummy code
  }
  
  private boolean isKingChecking() {
    
    return false;//dummy code
  }
}
