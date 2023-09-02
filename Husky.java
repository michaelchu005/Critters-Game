// Michael Chu
// 3/9/21
// CSE142
// TA: Patrick Murphy
// Assignment #8 (Critters)
//
// This class will display the huskies representaed by an asterisk in the flashing rainbow colors.
// They keep moving towards the top-left corner to group together and infect the
// other types of critters in front of them.


import java.awt.*;

public class Husky extends Critter {

   private int step;
   private Color[] colorList = {Color.RED, Color.ORANGE, Color.YELLOW,
                                Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};

   public Husky() {
      this.step = 0;
   }

   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else if (info.getDirection() == Direction.NORTH ||
                 info.getDirection() == Direction.EAST) {
         return Action.LEFT;
      } else if (info.getDirection() == Direction.SOUTH ||
                 info.getDirection() == Direction.WEST) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }
   
   public Color getColor() {
      this.step++;
      if (this.step == 7) {
         this.step = 1;
      }
      return colorList[this.step - 1];
   }
   
   public String toString() {
      return "*";
   }
}