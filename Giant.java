// Michael Chu
// 3/9/21
// CSE142
// TA: Patrick Murphy
// Assignment #8 (Critters)
//
// This class will display the giants (gray) represented by 4 different
// words (changing every 6 rounds). They keep moving forward until
// they reach another type of critters and infect them
// or reach a wall and turn right.

import java.awt.*;

public class Giant extends Critter {

   private int step;
   private String[] names = {"fee", "fie", "foe", "fum"};
   private int number;
   private String lastName;
   
   public Giant() {
      this.step = 0;
      this.number = 0;
   }

   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
       return Action.RIGHT;
      }
   }
   
   public Color getColor() {
      return Color.GRAY;
   }
   
   public String toString() {
      this.step++;
      if ((this.step + 5) % 6 == 0) {
         if (this.number == 3) {
            lastName = names[number].toString();
            this.number = 0;
            return lastName;
         } else {
            this.number++;
            lastName = names[number - 1].toString();
            return lastName;
         }
      } else {
         return lastName;
      }
   }
}