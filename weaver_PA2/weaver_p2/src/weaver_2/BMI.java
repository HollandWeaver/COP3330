package weaver_2;
import java.util.Scanner;
public class BMI {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		boolean isImperial = false;
		boolean isMetric = false;
		boolean isMale = false;
		String measuringSystem = "";
		double weight = 0;
		double height = 0;
		double bmi = 0;
		
		System.out.println("Hello! This is a BMI calculator. Would you like to calulate BMI in pounds or kilograms?");
		
		while ((isImperial == false) && (isMetric == false)) {
			measuringSystem = scnr.next();
			while ( !(measuringSystem.toLowerCase().matches("(.*)pound(.*)")) && !(measuringSystem.toLowerCase().matches("(.*)kilo(.*)")) ) {
				System.out.println("Please enter either pounds or kilograms.");
				measuringSystem = scnr.next();
			}
			if (measuringSystem.toLowerCase().matches("(.*)pound(.*)") ) {
				isImperial = true;
				System.out.println("Excellent choice!");
			} else if (measuringSystem.toLowerCase().matches("(.*)kilo(.*)") ) {
				isMetric = true;
				System.out.println("Brilliant choice!");
			}
		}
		
		if (isImperial) {   //imperial calculation
			System.out.println("What is your weight in pounds?");
			weight = scnr.nextDouble();
			while (weight < 0) {
				System.out.println("Please enter a positive value.");
				weight = scnr.nextDouble();
			}
			
			System.out.println("What is your height in inches?");
			height = scnr.nextDouble();
			while (height == 0) {
				System.out.println("Please enter a strictly positive value.");
				height = scnr.nextDouble();
			}
			
			bmi = (703 * weight) / Math.pow(height, 2);
		}
		else {   //metric calculation
			System.out.println("What is your weight in kilograms?");
			weight = scnr.nextDouble();
			while (weight < 0) {
				System.out.println("Please enter a positive value.");
				weight = scnr.nextDouble();
			}
			
			System.out.println("What is your height in centimeters?");
			height = scnr.nextDouble();
			while (height == 0) {
				System.out.println("Please enter a strictly positive value.");
				height = scnr.nextDouble();
			}
			
			bmi = weight / Math.pow((height / 100), 2);
		}
		
		System.out.printf("\nYour BMI is %.1f", bmi);
		
		System.out.println("\nYou can view the following table for BMI references:");
		System.out.printf("\nBMI Range\t Categories\n", bmi);
		System.out.printf("\n<18.5 \t\t Underweight");
		System.out.printf("\n 18.5–24.9 \t Normal weight");
		System.out.printf("\n 25–29.9 \t Overweight");
		System.out.printf("\n>30 \t\t Obesity");

	}

}
