// Programmer: Harpreet Sangha 
// Date: 01/18/2022
// Purpose: To create a simple guessing game that allows the user to guess a given integer for however many times
// until they get it right. The only problem that I have is that after the right answer is given the print statement

import java.util.Random;
import java.util.Scanner;

public class Game
{
   public static void main(String[] args)
   {
      int numTries;
      int bestGuess = 1000;
      int gameCount = 0;
      int sum = 0;

      instructions();
      
      System.out.print("\nWould you like to play: ");
      
      Scanner ask = new Scanner(System.in);
      char again = ask.next().charAt(0);
         
      char choice = Character.toUpperCase(again);

      while (choice == 'Y') 
      {
         numTries = playGame(); 
         if (numTries < bestGuess)
         {
            // Changes the value of bestGuess to get the total number of guesses
            bestGuess = numTries; 
         }
         sum += numTries; 
         gameCount++;
            
         System.out.print("Would you like to play again: ");
         again = ask.next().charAt(0);
         choice = Character.toUpperCase(again);
      }
      summary(gameCount, bestGuess, sum);
   }
     
   public static void instructions()
   {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   } 
   
   public static int playGame()
   {
      int max = 100; 
      int numTries = 0; 
      int guess = 0;
      
      Random rand = new Random();
      int randomNumber = rand.nextInt(max) + 1; 
      
      Scanner inputguess = new Scanner(System.in);
      System.out.print("\nI'am thinking of a number between 1 and " + max + ": "); 
         
      while (guess != randomNumber) 
      {
         guess = inputguess.nextInt();
         if (guess > randomNumber) 
         {
            System.out.println("Too high guess again");
            numTries++; 
         } 
         if (guess < randomNumber)
         {  
            System.out.println("Too low guess again");
            numTries++; 
         } 
      } 
          
      System.out.println("Congratulations you got it right in " + numTries + " tries");
      return numTries; 
   } 
   
   public static void summary(int gameCount, int sum, int bestGuess)
   {
      double average = (((double)bestGuess/(double)gameCount)); 
      System.out.println("Total games: " + gameCount);
      System.out.println("Total guesses: " + bestGuess);
      System.out.println("Best Guess: " + sum);
      System.out.printf("Your Average is: %.1f", average);  
   }
}