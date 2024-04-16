/*
 * Noah Gathings
 * Fadi Wedyan
 * CPSC 24500
 * 7 Feburary 2024
 * The purpose of this program is to create a calculator that reads the user's inputted salary and determines his/her income tax.
 */

import java.util.Scanner;

public class TaxCalculator {

	public static void main(String[] args) {
		// Scanner and variable declaration
		Scanner scan = new Scanner(System.in);
		String userName;
		double income;
		double tax = 0;
		
		// User input for initial display
		System.out.print("Please enter your full name (with space): ");
		userName = scan.nextLine();
		System.out.print("Please enter your income: ");
		income = scan.nextDouble();
		
		// Error message for invalid input
		if (income < 0) {
			System.out.print("Invalid input, income should be zero or more");
			return;
		}
		
		// J$4000 of salary tax is free
		if (income < 4000) {
			tax = 0;
		// Next J$1500 taxed at 10%
		} else if (income <= 5500) {
			tax = (income - 4000) * 0.1;
		// Next J$28000 taxed at 20%
		} else if (income <= 33500) {
			tax = 150;
			tax += (income - 5500) * 0.2;
		// Any amount > J$33500 is taxed at 40%
		} else {
			tax = 5750;
			tax += (income - 33500) * 0.4;
		}
		
		// Display for name, income, and income tax
		System.out.println("\nName: " + userName);
		System.out.println("Income: J$" + income);
		System.out.println("Income Tax: " + (int) tax);
			

	}

}
