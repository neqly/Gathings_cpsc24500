import java.util.Scanner;

/*
 * Noah Gathings
 *  Dr. Fadi Wedyan
 *  Assignment 7
 *  This program prompts the user to input two complex numbers and displays the result of their addition, subtraction, multiplication, division, and absolute value
 */

	class Complex implements Comparable<Complex> {
	    private double real;
	    private double imag;

	    // Initializing real and imaginary parts to 0
	    public Complex() {
	        this(0, 0);
	    }

	    // Constructor initializing real part and setting imaginary part to 0
	    public Complex(double real) {
	        this(real, 0);
	    }

	    // Constructor (two arguments) initializing both parts of complex number
	    public Complex(double real, double imag) {
	        this.real = real;
	        this.imag = imag;
	    }

	    // Copy constructor (creates new Complex object)
	    public Complex(Complex complex) {
	        this.real = complex.real;
	        this.imag = complex.imag;
	    }

	    // Getter methods
	    public double getRealPart() {
	        return real;
	    }

	    public double getImaginaryPart() {
	        return imag;
	    }

	    // Method to add complex numbers (returns result to new object)
	    public Complex add(Complex other) {
	        return new Complex(this.real + other.real, this.imag + other.imag);
	    }

	    // Method to subtract complex numbers
	    public Complex subtract(Complex other) {
	        return new Complex(this.real - other.real, this.imag - other.imag);
	    }

	    // Method to multiply complex numbers
	    public Complex multiply(Complex other) {
	        double newReal = this.real * other.real - this.imag * other.imag;
	        double newImag = this.imag * other.real + this.real * other.imag;
	        return new Complex(newReal, newImag);
	    }

	    // Method to divide complex numbers
	    public Complex divide(Complex other) {
	        double denom = other.real * other.real + other.imag * other.imag;
	        double newReal = (this.real * other.real + this.imag * other.imag) / denom;
	        double newImag = (this.imag * other.real - this.real * other.imag) / denom;
	        return new Complex(newReal, newImag);
	    }

	    // Method for finding absolute value of the complex number
	    public double abs() {
	        return Math.sqrt(real * real + imag * imag);
	    }

	    // Override compareTo in order to compare complex objects based on abs
	    @Override
	    public int compareTo(Complex other) {
	        return Double.compare(this.abs(), other.abs());
	    }

	    // Override toString in order to represent complex number as a string
	    @Override
	    public String toString() {
	    	// Format of complex number according to real and imaginary parts
	        if (imag == 0) {
	            return String.valueOf(real);
	        } else if (real == 0) {
	            return imag + "i";
	        } else if (imag < 0) {
	            return real + " - " + (-imag) + "i";
	        } else {
	            return real + " + " + imag + "i";
	        }
	    }
	}
	