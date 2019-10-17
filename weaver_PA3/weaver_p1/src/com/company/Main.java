package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private static Scanner scnr = new Scanner(System.in);
    private static SecureRandom ran = new SecureRandom();
    private static double num1, num2;
    private static double answer, userAnswer;
    private static int difficultyLevel, problemType, numCorrect = 0;
    private static boolean isFive = false;

    public static void main(String[] args) {

        while (true) {
            getProblemType();
            getDifficulty();
            for (int i = 0; i < 10; i++) {
                generateNewNumbers();
                askQuestion();
                getUserAnswer();

                if (Math.abs(userAnswer - answer) < 0.0001) {
                    printCorrectResponse();
                    numCorrect++;
                }
                else
                    printIncorrectResponse();

            }
            printSessionResults();
        }
    }

    private static void askQuestion(){
        if (problemType == 5){
            isFive = true;
            problemType = ran.nextInt(4) + 1;
        }
        switch (problemType) {
            case 1:
                System.out.println("What is " + (int)num1 + " plus " + (int)num2 + "?");
                answer = num1 + num2;
                break;
            case 2:
                System.out.println("What is " + (int)num1 + " times " + (int)num2 + "?");
                answer = num1 * num2;
                break;
            case 3:
                System.out.println("What is " + (int)num1 + " minus " + (int)num2 + "?");
                answer = num1 - num2;
                break;
            case 4:
                System.out.println("What is " + (int)num1 + " divided by " + (int)num2 + "?");
                answer = num1 / num2;
                break;

        }
        if(isFive)
            problemType = 5;
    }

    private static void generateNewNumbers(){
        num1 = ran.nextInt((int)Math.pow(10, difficultyLevel));
        num2 = ran.nextInt((int)Math.pow(10, difficultyLevel));
    }

    private static void getUserAnswer(){
        userAnswer = scnr.nextDouble();
    }

    private static void printCorrectResponse(){
        int x = ran.nextInt(4)+1;
        switch (x){
            case 1 :
                System.out.println("Very good!");
                break;
            case 2 :
                System.out.println("Excellent!");
                break;
            case 3 :
                System.out.println("Nice work!");
                break;
            case 4 :
                System.out.println("Keep up the good work!");
                break;
        }
        System.out.println();
    }

    private static void printIncorrectResponse(){
        int x = ran.nextInt(4)+1;
        switch (x){
            case 1 :
                System.out.println("No. Keep trying.");
                break;
            case 2 :
                System.out.println("Don't give up!");
                break;
            case 3 :
                System.out.println("Wrong. Try once more.");
                break;
            case 4 :
                System.out.println("No. Please try again.");
                break;
        }
    }

    private static void printSessionResults(){
        double percentCorrect = numCorrect/(.1);
        if (percentCorrect < .75){
            System.out.println("Please ask your teacher for extra help.");
        } else
            System.out.println("Congratulations, you are ready to go to the next level!");
        numCorrect = 0;

        System.out.println("New session starting.");
        System.out.println();
    }

    private static void getDifficulty(){
        System.out.println("Choose a difficulty level from 1 to 4.");

        difficultyLevel = scnr.nextInt();
    }

    private static void getProblemType(){
        System.out.println("Choose a type of problem to practice.");
        System.out.println("1 - Addition");
        System.out.println("2 - Multiplication");
        System.out.println("3 - Subtraction");
        System.out.println("4 - Division");
        System.out.println("5 - All of the above");

        problemType = scnr.nextInt();
    }

}

