package com.example._9_aigamecode.Game;

import java.util.Scanner;

public class InfixToPostfix1 {

    // User Input
    static String infixString = displayInfo();
    static char[] infixExpression = infixString.replaceAll("\\s", "").toCharArray();

    // Postfix
    static char[] postfix = new char[infixExpression.length];
    static int topForPostfix = -1;
    static char[] Operators = new char[noOfOperators()];
    static int topForOperatorStack = -1;

    static void main() {

        convertToPostfix();

    }

    static char push(char ch) {
        topForPostfix++;
        postfix[topForPostfix] = ch;

        return ch;
    }

    static char pushToOperatorStack(char ch) {
        topForOperatorStack++;

        if(topForOperatorStack > 0)
            checkPrecedences(ch);

        return ch;
    }

    static void checkPrecedences(char currOperator) {
        for(int i=topForOperatorStack; i>=0; i--) {
            if(checkPreced(Operators[i], currOperator))
                pushOperatorToPostfixExpression();
        }
    }

    static void pushOperatorToPostfixExpression() {
        System.out.println("Keep going Arham!...");
    }

    static boolean checkPreced(char left, char right) {
        int leftValue = checkRank(left);
        int rightValue = checkRank(right);

        return leftValue > rightValue;
    }

    static int checkRank(char ch) {
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '/' || ch == '*')
            return 2;
        else
            return 3;
    }

    static void convertToPostfix() {

        for(char ch: infixExpression) {

            // For Digits
            if(Character.isDigit(ch))
                push(ch);

            // For Operators
            else
                pushToOperatorStack(ch);
        }
    }

    static int noOfOperators() {

        int counter = 0;

        for(char ch: infixExpression) {
            if(!Character.isDigit(ch) && !Character.isLetter(ch) && ch!='(' && ch!=')')
                counter++;
        }

        return counter;
    }

    static String displayInfo() {

        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO INFIX TO POSTFIX CONVERSION!");
        System.out.println("=======================================");
        System.out.print("Please enter your expression here(i-e: 5+6/3*5^4): ");

        return input.nextLine();
    }

    static void iterate(char[] charArray) {
        for(char ch: charArray)
            System.out.print(ch + ", ");
    }

}
