package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Coordinate {
 int x;
 int y;
 
 public Coordinate(int x, int y){
   //Pre: None
   //Post: Creates coordinates
   this.x = x;
   this.y = y;
 }
 
 public Coordinate(Coordinate another) {
   //Pre: None
   //Post: Copies coordinates of another coordinate object
   this.x = another.x;
   this.y = another.y;
 }
 
 public int getXComponent() {
   //Pre: None
   //Post: returns x component of coordinate object
   return this.x;
 }
 
 public int getYComponent() {
   //Pre: None
   //Post: returns x component of coordinate object
   return this.y;
 }
 
 public static Coordinate add(Coordinate a, Coordinate b){
   //Pre: None
   //Post: Adds two coordinates
   return new Coordinate(a.x + b.x, a.y + b.y);
 }
 
 public static Coordinate subtract(Coordinate a, Coordinate b) {
   //Pre: None
   //Post: Subtracts two coordinates
   return new Coordinate(b.x - a.x, b.y - a.y);
 }
 
 public String toString() {
   //Pre: None
   //Post: When objected printed, it's understandable by human
   return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
 }
}
