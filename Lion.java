// Michael Chu
// 3/9/21
// CSE142
// TA: Patrick Murphy
// Assignment #8 (Critters)
//
// This class will display the lions represented by an "L" in the color
// of red, blue, or green (changing randomly every 3 rounds). They keep
// moving forward until they reach another type of critters and infect them
// or reach a wall and turn around.

import java.awt.*;

public class Lion extends Critter {
   
   private int step;
   private Color lastColor;
   
   public Lion() {
      this.step = 0;
   }

   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   public Color getColor() {
      this.step++;
      if ((this.step + 2) % 3 == 0) {
         Color randomColor = randomColor();
         this.lastColor = randomColor;
         return lastColor;
      } else {
         return this.lastColor;
      }

   }
   
   public Color randomColor() {
      double random = Math.random();
      if (random >= 2.0 / 3) {
         return Color.BLUE;
      } else if (random >= 1.0 / 3) {
         return Color.GREEN;
      } else {
         return Color.RED;
      }
   }
   
   public String toString() {
      return "L";
   }

}