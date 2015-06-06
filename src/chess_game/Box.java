package chess_game;

public class Box {
	boolean isOccupied = false;
	Coordinate coords;
	Piece piece;
	
	public Box(boolean isOccupied, char x, char y, Piece piece){
		this.isOccupied = isOccupied;
		coords = new Coordinate(x,y);
		this.piece = piece;
	}
	
	public Coordinate getCoordinates(){
		return coords;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
}
