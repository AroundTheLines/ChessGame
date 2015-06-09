package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Coordinate {
 int x;
 int y;
 
 public Coordinate(int x, int y){
   //Pre:
   //Post:
   this.x = x;
   this.y = y;
 }
 
 public Coordinate(Coordinate another) {
   //Pre:
   //Post:
   this.x = another.x;
   this.y = another.y;
 }
 
 public int getXComponent() {
   //Pre:
   //Post:
   return this.x;
 }
 
 public int getYComponent() {
   //Pre:
   //Post:
   return this.y;
 }
 
 public static Coordinate add(Coordinate a, Coordinate b){
   //Pre:
   //Post:
   return new Coordinate(a.x + b.x, a.y + b.y);
 }
 
 public static Coordinate subtract(Coordinate a, Coordinate b) {
   //Pre:
   //Post:
   return new Coordinate(b.x - a.x, b.y - a.y);
 }
 
 public String toString() {
   //Pre:
   //Post:
   return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
 }
}
