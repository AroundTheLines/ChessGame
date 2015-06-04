package chess_game;

public class Box {
	boolean isOccupied;
	char x;
	char y;
	Object piece;
	char display;
	
	public Box(boolean isOccupied, char x, char y, Object piece, char display){
		this.isOccupied = isOccupied;
		this.x = x;
		this.y = y;
		this.piece = piece;
		this.display = display;
	}
	
	public char pieceColor(){
		return piece.color;//waiting for andany's piece class
	}
}
