package com.example._9_aigamecode.Game;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static int top = -1;
    public static int topForOperators = -1;
    public static int topForOperands = -1;

    static Character[] charArr = new Character[displayInfo()];


    static Character[] operators = new Character[checkNoOfOperators()];
    static Character[] operands = new Character[checkNoOfOperands()];


    static int[] arr = new int[charArr.length];

    static void main() {
        loadExpression();
        convertToPostfix();
        System.out.println(pred('-', '+'));
    }

    static void convertToPostfix() {

        for(int i=0; i<charArr.length; i++) {
            if(!Character.isDigit(charArr[i]))
                pushForOperators(charArr[i]);
            else
                pushForOperands(charArr[i]);

        }

    }

    static int checkNoOfOperators() {
        int counter = 0;
        for(int i=0; i<charArr.length; i++) {
            if(!(Character.isDigit(charArr[i]) || Character.isLetter(charArr[i])))
                counter++;
        }
        return counter;
    }

    static int checkNoOfOperands() {
        int counter = 0;
        for(int i=0; i<charArr.length; i++) {
            if(Character.isDigit(charArr[i]) || Character.isLetter(charArr[i]))
                counter++;
        }
        return counter;
    }

    static void push(int elem) {
        top++;
        arr[top] = elem;
    }
    static int pop() {
        int elem = arr[top];
        top--;
        return elem;
    }

    static void pushForOperators(char elem) {
        topForOperators++;
        operators[topForOperators] = elem;
    }

    static char popForOperators() {
        char elem = operators[topForOperators];
        topForOperators--;
        return elem;
    }

    static void pushForOperands(char elem) {
        topForOperands++;
        operands[topForOperands] = elem;
    }

    static char popForOperands() {
        char elem = operands[topForOperands];
        topForOperands--;
        return elem;
    }

    static boolean pred(char op1, char op2){
        int value1 = checkValue(op1);
        int value2 = checkValue(op2);

        return value1 > value2;
    }

    static int checkValue(char ch) {
        if(ch == '+' || ch == '-')
            return 1;
        else if (ch == '/' || ch == '*')
            return 2;
        else
            return 3;
    }

    static int displayInfo() {
        Scanner input = new Scanner(System.in);

        System.out.println("HEY! WELCOME.");
        System.out.println("=================");

        System.out.print("\nNumber of elements in your expression: ");

        return input.nextInt();
    }

    static void loadExpression() {
        Scanner input = new Scanner(System.in);

        for(int i=0; i< charArr.length; i++) {
            System.out.printf("Enter Element %02d: " , i+1);
            charArr[i] = input.next().charAt(0);
        }

        System.out.println("Expression Loaded Successfully!");
    }
}
