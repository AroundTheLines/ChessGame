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
 
 public static Coordinate add(Coordinate a, Coordinate b){
  return new Coordinate(a.x + b.x, a.y + b.y);
 }
}
