
import java.util.Scanner;

public class GemAndJewelryTables
{
   public static void main(String[] args) 
   {      
      input();     
   }
   
   public static void input()
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter Gems or Jewelry:");
      String answer = input.next().toLowerCase();
      System.out.print(">>> ");
      
      if(answer.equals("gems"))
      {
         System.out.println("How many gems are there?");
         int quantity = input.nextInt();
         System.out.print(">>> ");
         System.out.println("The value of the gem hoard is: " + gemHoard(quantity));
      }
      else if(answer.equals("jewelry"))
      {
         System.out.println("How many pieces of jewelry are there?");
         int quantity = input.nextInt();
         System.out.print(">>> ");
         System.out.println("The value of the jewelry hoard is: " + jewelryHoard(quantity));
      }
      else
      {
         System.out.println("Sorry that input is not recognized please run the program again.");
      }
      
   }
    
   // when calling this method any single die value can be used 
   // it will return a random number between 1 and the value of the die
   public static int rollD(int die)
   {    
      return (int)(Math.random()*die) + 1;
   }
   
   // This if else chain is the same as in the 1st edition AD&D dungeon masters guide
   // it is used for determining the value of an individual gem
   public static int gemValue(int roll)
   {
      if(roll <= 25)
         return 10;
      else if(roll >= 26 && roll <= 50)
         return 50;
      else if(roll >= 51 && roll <= 70)
         return 100;
      else if(roll >= 71 && roll <= 90)
         return 500;
      else if(roll >= 91 && roll <= 99)
         return 1000;
      else if(roll == 100)
         return 5000;
      return 0;
   }
   
   // This if else chain is the same as in the 1st edition AD&D dungeon masters guide
   // it is used for determining the value of an individual piece of jewelry
   public static int jewelryValue(int roll)
   {
      if(roll <= 10)
         return rollD(10)*100;
      else if(roll >= 11 && roll <= 20)
         return (rollD(6)+rollD(6)) * 100;
      else if(roll >=21 && roll <= 40)
         return (rollD(6) + rollD(6) + rollD(6)) * 100;
      else if(roll >= 41 && roll <= 50)
         return (rollD(6) + rollD(6) + rollD(6)+ rollD(6) + rollD(6)) * 100;
      else if(roll >= 51 && roll <= 70)
         return (rollD(6)) * 1000;
      else if(roll >= 71 && roll <= 90)
         return (rollD(4) + rollD(4)) * 1000;
      else if(roll >=91)
         return (rollD(6)+rollD(6)) * 1000;
      return 0;
   }
   
   //This method will add up individual gems and return a total gold piece value
   public static int gemHoard(int amount)
   {
      int totalValue = 0;
      for(int i = 0; i < amount; i++)
         {
            totalValue += gemValue(rollD(100));
         }
      return totalValue; 
   }
   
   //This method will add up individual pieces of jewelry and return a total gold piece value
   public static int jewelryHoard(int amount)
   {
      int totalValue = 0;
      for(int i = 0; i < amount; i++)
         {
            totalValue += jewelryValue(rollD(100));
         }
      return totalValue; 
   }
}