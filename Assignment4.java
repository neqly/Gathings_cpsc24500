/*
 * Noah Gathings
 * Dr. Fadi Wedyan
 * Assignment 4
 * This program will read contents from a text file into a two-dimensional array. The array will perform several operations.
 */

import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment4 {
	
		// Counting number of lines within the file
	/**
	 * @param filename
	 * @return number of lines in a text file
	 * @throws IOException
	 */
    public static int getNoLines(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
    
	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
    
    public static int[][] create2DArr(String fileName) {
        int[][] result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int rows = getNoLines(fileName);
            result = new int[rows][];
	            String line;
	            int row = 0;
	            // Reading each line in file
	            while ((line = reader.readLine()) != null) {
	            	// Splitting line into separate values
	                String[] values = line.trim().split("\\s+");
	                // Initializing another array to hold values
	                int[] rowArr = new int[values.length];
	                // Storing values in the array after converting them to int
	                for (int i = 0; i < values.length; i++) {
	                    rowArr[i] = Integer.parseInt(values[i]);
	                }
	                // Storing row array in 2D array
	                result[row++] = rowArr;
	            }
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    // Finding longest row in 2D array
	    public static int findLongestRow(int[][] arr) {
	        int longestRowIndex = 0;
	        int maxLength = 0;
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i].length > maxLength) {
	                maxLength = arr[i].length;
	                longestRowIndex = i;
	            }
	        }
	        return longestRowIndex;
	    }

	    // Finding max value in the specified row of the 2D array
	    public static int findMaxInRow(int[][] arr, int rowIndex) {
	        int max = Integer.MIN_VALUE;
	        for (int i = 0; i < arr[rowIndex].length; i++) {
	            if (arr[rowIndex][i] > max) {
	                max = arr[rowIndex][i];
	            }
	        }
	        return max;
	    }

	    // Finding max value in the whole 2D array
	    public static int findMax(int[][] arr) {
	        int max = Integer.MIN_VALUE;
	        for (int[] row : arr) {
	            for (int value : row) {
	                if (value > max) {
	                    max = value; // Update max value if necessary
	                }
	            }
	        }
	        return max;
	    }

	    // Main method testing functionality of other methods
	    public static void main(String[] args) {
	    	// Provide full path if the file is not in the same directory
	        String file = "/Users/noahcg8/Downloads/assignment4Data.txt";
	        // Creating 2D array from file contents
	        int[][] arr = create2DArr(file);
	        // Finding index of longest row
	        int longestRowIndex = findLongestRow(arr);
	        // Displaying results
	        System.out.println("Number of lines in the file = " + getNoLines(file));
	        System.out.println("Longest row in the file is: " + (longestRowIndex + 1) + ", with length of: " + arr[longestRowIndex].length);        
	        System.out.println("Max value in first row= " + findMaxInRow(arr, 0));
	        System.out.println("Max value in the array = " + findMax(arr));
	    }
	}

