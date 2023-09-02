// Michael Chu
// 3/9/21
// CSE142
// TA: Patrick Murphy
// Assignment #8 (Critters)
//
// This class will display the bears (black) and the polar bears (white)
// represented by slashes and backslashes. They keep moving forward until
// they reach another type of critters and infect them
// or reach a wall and turn left.

import java.awt.*;

public class Bear extends Critter {

   private int step;
   private boolean polar;
   
   public Bear (boolean polar) {
      this.step = 0;
      this.polar = polar;
   }
   
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
   
   public Color getColor() {
      if (this.polar) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   public String toString() {
      this.step++;
      if ((step + 1) % 2 == 0) {
         return "/";
      } else {
         return "\\";
      }
   }

}