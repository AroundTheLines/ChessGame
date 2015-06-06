package chess_game;

public class Box {
	boolean isOccupied = false;
	Coordinate coords;
	Piece piece;
	
	public Box(boolean isOccupied, char x, char y, Piece piece){
		this.isOccupied = isOccupied;
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
}
