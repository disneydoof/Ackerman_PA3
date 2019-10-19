package com.company;
import java.security.SecureRandom;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Double;

public class Main {

    public static void main(String[] args) {

        setup(arithmetic(), difficulty());

    }

    public static int arithmetic () {
        Scanner sc = new Scanner(System.in);

        System.out.println("Lets study Math! Choose which type of problems you would like to practice.");
        System.out.println("Type (1) to study addition.");
        System.out.println("Type (2) to study multiplication.");
        System.out.println("Type (3) to study subtraction.");
        System.out.println("Type (4) to study division.");
        System.out.println("Type (5) to study all of these types.");

        int answer = sc.nextInt();
        return answer;

    }

    public static int difficulty (){
        Scanner sc = new Scanner(System.in);

        System.out.println("At which difficulty would you like to practice at?");
        System.out.println("Type (1) to only use single digits in your problems.");
        System.out.println("Type (2) to use double and single digit numbers in your problems.");
        System.out.println("Type (3) to use triple, double and single digit numbers in your problems.");
        System.out.println("Type (4) to use quadruple, triple, double and single digit numbers in your problems.");

        int answer = sc.nextInt();
        return answer;

    }
    public static int setup(int arithmetic, int difficulty) {
        SecureRandom rand = new SecureRandom();

        int tally = 0;
        double percentage;

        if (difficulty == 1) {
            difficulty = 10;
        } else if (difficulty == 2) {
            difficulty = 100;
        } else if (difficulty == 3) {
            difficulty = 1000;
        } else if (difficulty == 4) {
            difficulty = 10000;
        }

        for (int i = 0; i < 10; i++) {

            int ranOne = rand.nextInt(difficulty);
            int ranTwo = rand.nextInt(difficulty);
            ranOne += 1;
            ranTwo += 1;


            switch (arithmetic) {
                case 1:
                    tally += addition(ranOne, ranTwo);
                    break;
                case 2:
                    tally += multiplication(ranOne, ranTwo);
                    break;
                case 3:
                    tally += subtraction(ranOne, ranTwo);
                    break;
                case 4:
                    tally += division(ranOne, ranTwo);
                    break;
                case 5:
                    tally += random(ranOne, ranTwo);
                    break;
            }
        }

        if (tally >= 8){
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("You got " + tally + " right out of 10 questions!");
        }
        else{
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("You got " + tally + " right out of 10 questions");
        }
        return 0;
    }

    public static int multiplication (int ranOne, int ranTwo){
        Scanner sc = new Scanner(System.in);

        int correctAnswer = ranOne * ranTwo;

        System.out.println("What is " + ranOne + " times " + ranTwo + "?");

        int userAnswer = sc.nextInt();

        if (correctAnswer == userAnswer){
            return 1;
        }
        else {
            return 0;
        }

    }

    public static int addition (int ranOne, int ranTwo){
        Scanner sc = new Scanner(System.in);

        int correctAnswer = ranOne + ranTwo;

        System.out.println("What is " + ranOne + " plus " + ranTwo + "?");

        int userAnswer = sc.nextInt();

        if (correctAnswer == userAnswer){
            return 1;
        }
        else {
            return 0;
        }

    }

    public static int subtraction (int ranOne, int ranTwo){
        Scanner sc = new Scanner(System.in);

        int correctAnswer = ranOne - ranTwo;

        System.out.println("What is " + ranOne + " minus " + ranTwo + "?");

        int userAnswer = sc.nextInt();

        if (correctAnswer == userAnswer){
            return 1;
        }
        else {
            return 0;
        }

    }

    public static int division (int ranOneInt, int ranTwoInt){
        Scanner sc = new Scanner(System.in);

        double ranOne = ranOneInt;
        double ranTwo = ranTwoInt;

        double correctAnswer = ranOne / ranTwo;

        System.out.println("What is " + ranOne + " divided by " + ranTwo + "?");
        System.out.println("Round to the second decimal place if needed.");

        double userAnswer = sc.nextDouble();

        if (Math.abs(userAnswer - correctAnswer) < 1e-2){
            return 1;
        }
        else {
            return 0;
        }

    }

    public static int random (int ranOne, int ranTwo){
        SecureRandom rand = new SecureRandom();

        int arithmetic = rand.nextInt(5);
        arithmetic += 1;
        int tally = 0;

        switch (arithmetic) {
            case 1:
                tally += addition(ranOne, ranTwo);
                break;
            case 2:
                tally += multiplication(ranOne, ranTwo);
                break;
            case 3:
                tally += subtraction(ranOne, ranTwo);
                break;
            case 4:
                tally += division(ranOne, ranTwo);
                break;
        }
        return tally;
    }


}


