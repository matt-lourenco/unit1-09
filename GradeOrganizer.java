/****************************************************************************
 *
 * Created by: Matthew Lourenco
 * Created on: Feb 2018
 * This program creates a 4 x 6 array of students and grades (4 students and
 *     6 assignments). It then finds the average of these grades.
 *
 ****************************************************************************/

import java.util.Random;

public class GradeOrganizer {

	private static int randomSkewedNumber() {
		//This method generates two random numbers and returns the larger one
		Random rand = new Random();
		int randomNumber1 = rand.nextInt(99) + 1;
		int randomNumber2 = rand.nextInt(99) + 1;
		if(randomNumber1 > randomNumber2) {
			return randomNumber1;
		} else {
			return randomNumber2;
		}
	}
	
	private static double findAverage(double[][] array) {
		//finds the average of a 2D array (a class of students)
		
		double[] studentAverages = new double[array.length];
		double studentScore = 0;
		double overallScore = 0;
		
		//find average of each student
		for(int student = 0; student<array.length; student++) {
			studentScore = 0;
			for(double assignment: array[student]) {
				studentScore += assignment;
			}
			studentAverages[student] = studentScore / array[student].length;
		}
		
		//find average of entire class
		for(double studentAverage: studentAverages) {
			overallScore += studentAverage;
		}
		//return the class average
		return (double) Math.round(overallScore / studentAverages.length
				* 100) / 100;
	}
	
	public static void main(String[] args) {
		// Generates a 4 x 6 array and fills with randomSkewedNumber()s
		
		double[][] classroom = new double[4][6];
		
		//fill with random skewed numbers
		for(double[] student: classroom) {
			for(int assignment=0; assignment<student.length; assignment++) {
				student[assignment] = randomSkewedNumber();
			}
		}
		
		//print each student's score
		for(int student=0; student<classroom.length; student++) {
			System.out.print("Student" + (student+1) + ":");
			for(double assignment: classroom[student]) {
				System.out.print(" "+(int)assignment);
			}
			System.out.println();
		}
		System.out.println("The class average is " + findAverage(classroom));
	}
}