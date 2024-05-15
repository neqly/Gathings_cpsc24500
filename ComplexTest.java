import java.util.Scanner;

/*
 * Noah Gathings
 *  Dr. Fadi Wedyan
 *  Assignment 7
 *  This program prompts the user to input two complex numbers and displays the result of their addition, subtraction, multiplication, division, and absolute value
 */

public class ComplexTest {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        // User input for real and imaginary parts of first complex number
	        System.out.print("Enter the first complex number: ");
	        double real1 = scan.nextDouble();
	        double imag1 = scan.nextDouble();
	        Complex complex1 = new Complex(real1, imag1);

	        // User input for real and imaginary parts of second complex number
	        System.out.print("Enter the second complex number: ");
	        double real2 = scan.nextDouble();
	        double imag2 = scan.nextDouble();
	        Complex complex2 = new Complex(real2, imag2);

	        // Displaying operations of the complex numbers
	        System.out.println(complex1 + " + " + complex2 + " = " + complex1.add(complex2));
	        System.out.println(complex1 + " - " + complex2 + " = " + complex1.subtract(complex2));
	        System.out.println(complex1 + " * " + complex2 + " = " + complex1.multiply(complex2));
	        System.out.println(complex1 + " / " + complex2 + " = " + complex1.divide(complex2));
	        // Absolute value of first complex number
	        System.out.println("|" + complex1 + "| = " + complex1.abs());
	    }
	}

