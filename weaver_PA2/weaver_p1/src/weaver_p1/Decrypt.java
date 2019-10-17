package weaver_p1;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userCode = 0;
		String codeString = "";
		int[] codeArr = new int[4];
		boolean isFourDigit = false;
		
		//get 4 digit code to decrypt
		System.out.println("Enter the four digit (0000 to 9999) code you'd like to decrypt:");
		while(isFourDigit == false) {
			codeString = scnr.next();
			while (codeString.length() != 4) {
				System.out.println("Please only enter a code from 0000 to 9999.");
				codeString = scnr.next();
			}
			userCode = Integer.parseInt(codeString);
			isFourDigit = true;
			System.out.println("Code to decrypt: " + codeString);
		}		
		
		//initialize array from String to modify values
		for (int i = 0; i < codeArr.length; i++) {
			codeArr[i] = Character.getNumericValue(codeString.charAt(i));
		}
		//DECRYPTION PROCESS
				System.out.print("Decryption: ");
				//swap
				for (int i = 0; i < 2; i++) {
					int tmp = codeArr[i];
					codeArr[i] = codeArr[i+2];
					codeArr[i+2] = tmp;
				}
				
				for (int i = 0; i < codeArr.length; i++) {
					if ((codeArr[i] -7) >= 0) {
						codeArr[i] -= 7;
						System.out.print(codeArr[i]);
					} else {
						codeArr[i] += 3;
						System.out.print(codeArr[i]);
					}
				}

	}

}
