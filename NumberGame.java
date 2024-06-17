package internshipTasks;

import java.util.Random;
import java.util.Scanner;


public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10; 
        int score = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to Guess the Number game!");

        do {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (roundsPlayed + 1) + ": I have generated a number between " + minRange + " and " + maxRange + ". Guess it!");

            while (attempts < attemptsLimit) {
                System.out.print("Attempt " + (attempts + 1) + "/" + attemptsLimit + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += attempts;
                    break;
                } else if (guess < randomNumber/2) {
                    System.out.println("Too low!");
                } else if(guess < randomNumber) {
                    System.out.println("Low!");
                }
                  else if(guess < (2*randomNumber)){
                    System.out.println("High!");
                }
                  else
                    System.out.println("Too high!");



            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've exceeded the limit of attempts. The correct number was: " + randomNumber);
            }

            roundsPlayed++;

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("\nGame over! Rounds played: " + roundsPlayed + ", Total score: " + score);
        scanner.close();
    }
    
}
