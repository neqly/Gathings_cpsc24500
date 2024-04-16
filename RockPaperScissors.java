/*
 * Noah Gathings
 * Dr. Fadi Wedyan
 * CPSC 24500
 * 21 February 2024
 * This program will allow the user to play a game of "Rock, Paper, Scissors" against the computer.
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		// Scanner and Random object declaration
		Scanner scan = new Scanner(System.in);
		Random gen = new Random();
		boolean playAgain = true; // playAgain is true to continue game if user decides
		
		//Display of game and rules
		System.out.println("\n*========================================*");
		System.out.println("Welcome to the Rock, Paper Scissors Game!");
		System.out.println("Here are the Rules:");
		System.out.println("1. Paper beats rock.");
		System.out.println("2. Rock beats scissors.");
		System.out.println("3. Scissors beats paper.");
		System.out.println("*========================================*");
		System.out.print("\nPlease enter your name: ");
		String user = scan.nextLine();
		
		// While loop if user wants to play again
		while (playAgain) {	
		System.out.print("\nHi, " + user + "! Enter 1 for Rock, 2 for Paper, or 3 for Scissors: ");
		int userChoice = getUserChoice(scan); // Calling for user input
		int cpuChoice = gen.nextInt(3) + 1; // Generating random number between 1-3 for computer
		System.out.println("\nComputer chose " + intToChoice(cpuChoice) + ". You chose " + intToChoice(userChoice) + ".");

		int result = getWinner(userChoice, cpuChoice); // Determining winner of game
		displayWinner(result); // Displaying winner of game
		playAgain = choosePlayAgain(scan); // Asking user if they want to play again
	
	}
}
	
	// Method to get user's choice
	public static int getUserChoice(Scanner scan) {
		while (true) {
			int userChoice = scan.nextInt();
			if (userChoice >= 1 && userChoice <= 3) { // Setting bounds for user input
				return userChoice;
			} else {
					// Error message if incorrect value is entered and user will enter again
					System.out.print("Invalid input. Please enter a number between 1 and 3: ");
				}
			}
		}
	
	// Method to determine the winner between user and computer
	public static int getWinner(int userChoice, int cpuChoice) {
		if (userChoice == cpuChoice) {
            return 0; // Tie
          // Rock beats scissors, paper beats rock, and scissors beats paper
        } else if ((userChoice == 1 && cpuChoice == 3) || (userChoice == 2 && cpuChoice == 1) || (userChoice == 3 && cpuChoice == 2)) {
            return 1; // User wins
        } else {
            return -1; // Computer wins
        }
	}
	
	// Method to convert user and computer int values to String choices
	public static String intToChoice(int userChoice) {
		switch (userChoice) {
		case 1:
			return "Rock";
		case 2:
			return "Paper";
		case 3:
			return "Scissors";
		default:
			return "Invalid choice";
		}
		
	}
	
	// Method to display the winner of game or if there was a tie
	public static int displayWinner(int result) {
		if (result == 0) {
            System.out.println("It's a tie! Let's play again.");
        } else if (result == 1) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Sorry, you lost. Better luck next time!");
        }
		return result;
	}

	// Method for asking user if they want to play another game
	public static boolean choosePlayAgain(Scanner scan) {
        System.out.println("Do you want to play again? (Enter Y to continue or any other key to stop): ");
        char playAgainChoice = scan.next().charAt(0);
        return (playAgainChoice == 'Y' || playAgainChoice == 'y'); // boolean playAgain will be set to true if user chooses "Y" and set to false otherwise
    }
}
