package weaver_p1;

import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userCode = 0;
		String codeString = "";
		int[] codeArr = new int[4];
		boolean isFourDigit = false;
		
		//get 4 digit code to encrypt
		System.out.println("Enter the four digit (0000 to 9999) code you'd like to encrypt:");
		while(isFourDigit == false) {
			codeString = scnr.next();
			while (codeString.length() != 4) {
				System.out.println("Please only enter a code from 0000 to 9999.");
				codeString = scnr.next();
			}
			userCode = Integer.parseInt(codeString);
			isFourDigit = true;
		}		
		
		//initialize array from String to modify values
		for (int i = 0; i < codeArr.length; i++) {
			codeArr[i] = Character.getNumericValue(codeString.charAt(i));
		}
		
		//ENCRYPTION PROCESS
		for (int i = 0; i < codeArr.length; i++) {
			codeArr[i] += 7;
			codeArr[i] %= 10;
		}
		//swap
		for (int i = 0; i < 2; i++) {
			int tmp = codeArr[i];
			codeArr[i] = codeArr[i+2];
			codeArr[i+2] = tmp;
		}
		
		System.out.print("Encryption: ");
		for (int i = 0; i < codeArr.length; i++) {
			System.out.print(codeArr[i]);
		}
	
		
		
	}
}
