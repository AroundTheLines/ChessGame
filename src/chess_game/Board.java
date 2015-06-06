package chess_game;
/*TODO: 
-initialize board array
*/

public class Board {
	
	static Box[][] board = new Box[8][8];
	
	public Board(){
		
	}
	
	public static Coordinate getPieceCoordinates(Piece p){
		for(int i = 0; i< board.length; i++){
			for(int j = 0; j<board[i].length;j++){
				if(board[i][j].getPiece() == p){
					return board[i][j].getCoordinates();
				}
			}
		}
		return null;
	}
	
	public static Box getBox(Coordinate z){
		return board[z.y][z.x];
	}
	
	public static Piece getPieceInBox(Coordinate z){
		return board[z.y][z.x].getPiece();
	}
}
