package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	/**
	* Reads a file containing two columns of floating point-numbers,
	* then prints to a different file the average of each column.
	* The average of column 1 should print on line 1 of the output file;
	* the average of column 2 on line 2.
	*
	* @param inFileName input filename (assume that all input files
	* will contain only two columns of numbers
	and
	* will not be empty)
	* @param outFileName output filename
	*/
	public static void problem1_averageColumns(String inFileName, String
	outFileName) {
		try {
			File inFile = new File(inFileName);
			Scanner in = new Scanner(inFile);
			PrintWriter out = new PrintWriter(outFileName);
			
			int count1, count2;
			count1 = count2 = 0;
			
			double sum1, sum2;
			sum1 = sum2 = 0;
			
			while (in.hasNextDouble()) {		
				sum1 += in.nextDouble();
				count1++;
				
				sum2 += in.nextDouble();
				count2++;
			}
			
			out.println(sum1/count1);
			out.println(sum2/count2);
			
			in.close();
			out.close();
			
		} catch (FileNotFoundException exception) {
			System.out.println(String.format("File: %s not found", inFileName));
		}
	}
}