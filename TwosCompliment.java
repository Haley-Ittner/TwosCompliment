import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TwosCompliment {

   public static void main(String [] args) {
      ArrayList<String> starter = new ArrayList<String>();
      ArrayList<String> flip = new ArrayList<String>();
      ArrayList<String> end = new ArrayList<String>();
      String carries = "0";
      String response;
      String holder = "";
      int counter = 0;
      String endValue = "";
      int kind = 0;
      Scanner scnr = new Scanner(System.in);
      kind = JOptionPane.showConfirmDialog(null, "Would you like to continue in dialog boxes?");
      if (kind == 1) {
         System.out.println("Please enter your binary number"); 
         response = scnr.nextLine();
         starter = putter(response);
         flip = flipper(starter);
         for( int x = starter.size() - 1; x > -1; x--) {
            if (x == starter.size() - 1) {
               holder = adder(flip.get(x), carries, "1");
               end.add(holder.substring(0,1));
               carries = holder.substring(1, holder.length());
               holder = "";             
            } else {
               holder = adder(flip.get(x), carries, "0");
               end.add(holder.substring(0,1));
               carries = holder.substring(1, holder.length());
               holder = "";      
            }
         }
         endValue = printer(end);
         System.out.println("Your number, " + response + ", in twos complement is  " + endValue);        
      } else if (kind == 0) {
         response = JOptionPane.showInputDialog(null, "Please enter your binary number");
         starter = putter(response);
         flip = flipper(starter);
         for( int x = starter.size() - 1; x > -1; x--) {
            if (x == starter.size() - 1) {
               holder = adder(flip.get(x), carries, "1");
               end.add(holder.substring(0,1));
               carries = holder.substring(1, holder.length());
               holder = "";             
            } else {
               holder = adder(flip.get(x), carries, "0");
               end.add(holder.substring(0,1));
               carries = holder.substring(1, holder.length());
               holder = "";      
            }
         }
         endValue = printer(end);
         JOptionPane.showMessageDialog(null, "Your number, " + response + ", in twos complement is " + endValue); 
      } else {
         JOptionPane.showMessageDialog(null, "Goodbye!");
      }      
   }  
   
   public static String adder(String value, String carry, String add) {
      double newValue = 0.0;
      double newCarry = 0.0;
      double newAdd = 0.0;
      newValue = Double.parseDouble(value);
      newCarry = Double.parseDouble(carry);
      newAdd = Double.parseDouble(add);
      if ((newValue + newCarry + newAdd == 3) || (newValue + newCarry + newAdd == 0)) {
         return value + " " +  value;
      } else if (newValue + newCarry + newAdd == 2) {
         return "0 1";
      } else {
         return "1 0";
      }     
   }
   
   public static ArrayList flipper(ArrayList startNumber) {
      ArrayList<String> flipped = new ArrayList<String>();
      for(int x = 0; x < startNumber.size(); x ++) {
         if (startNumber.get(x).equals("1")) {
            flipped.add("0");
         } else {
            flipped.add("1");
         }         
      }
      return flipped;
   }
   
   public static ArrayList putter(String number) {
      ArrayList<String> start = new ArrayList<String>();
      for(int x = 0; x < number.length(); x++) {
         start.add(number.substring(x, x + 1));
      }
      return start;
   }
   
   public static String printer(ArrayList ender) {
      String value = "";
      for(int x = ender.size() - 1; x > -1; x--) {
         value += ender.get(x);
      }
      return value;
   }
}