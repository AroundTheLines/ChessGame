package chess_game;

public class Coordinate {
	int x;
	int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Coordinate addCoordinate(Coordinate z){
		this.x+= z.x;
		this.y+= z.y;
		return this;
	}
	
	public Coordinate subtractCoordinate(Coordinate z){
		this.x-= z.x;
		this.y-= z.y;
		return this;
	}
}
