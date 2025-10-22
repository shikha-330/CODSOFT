import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String playAgain = "yes";
        int totalScore = 0;
        int round = 0;
        System.out.println(" Welcome to the Number Guessing Game!");
        
        while (playAgain.equalsIgnoreCase("yes")) {      // Multiple rounds
            round++;
            int secretNumber = rand.nextInt(100) + 1;
            int maxAttempts = 7;                                        //  limit attempts
            int attempts = 0;
            boolean correct = false;

            System.out.println("\nRound " + round + " begins!");
            System.out.println("I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Let's go!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    correct = true;
                    System.out.println("Are Waah!!! You guessed it right in " + attempts + " tries.");
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points this round!");
                    break;
                } 
                else if (guess < secretNumber) {
                    System.out.println(" Too low! Try a bigger number.");
                } 
                else {
                    System.out.println(" Too high! Try a smaller number.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts! The correct number was: " + secretNumber);
                }
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = sc.next();
        }
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + round);
        System.out.println("Your Final Score: " + totalScore + " points");
        System.out.println("Thanks for playing! See you again ");
        sc.close();
    }
}