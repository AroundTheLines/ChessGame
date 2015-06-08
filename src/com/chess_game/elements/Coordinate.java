package com.chess_game.elements;
import com.chess_game.pieces.*;

public class Coordinate {
 int x;
 int y;
 
 public Coordinate(int x, int y){
  this.x = x;
  this.y = y;
 }
 
 public Coordinate(Coordinate another) {
   this.x = another.x;
   this.y = another.y;
 }
 
 public Coordinate addCoordinate(Coordinate c){
  this.x += c.x;
  this.y += c.y;
  return this;
 }
 
 public int getXComponent() {
   return this.x;
 }
 
 public int getYComponent() {
   return this.y;
 }
 
 public static Coordinate add(Coordinate a, Coordinate b){
  return new Coordinate(a.x + b.x, a.y + b.y);
 }
 
 public static Coordinate substract(Coordinate a, Coordinate b) {
   return new Coordinate(b.x - a.x, b.y - a.y);
 }
 
 public String toString() {
   return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
 }
}
