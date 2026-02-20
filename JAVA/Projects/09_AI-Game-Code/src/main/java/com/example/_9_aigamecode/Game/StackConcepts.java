package com.example._9_aigamecode.Game;

import java.util.Scanner;
import java.util.Stack;

public class StackConcepts {

    public static int top = -1;

    static int[] arr = new int[displayMenu()];

    static void main() {
        Stack<Integer> myStack = new Stack<>();

        // Loading or Inserting
        int elem;
        for(int i=0; i< arr.length; i++) {
            elem = getElement(i+1);
            push(elem);
        }

        // Printing
        for (int i=0; i<=top; i++) {
            System.out.println("Inserting " + arr[i]);
        }
        System.out.print("Stack: ");
        for(int i=0; i<=top; i++) {
            System.out.print(arr[i] + ", ");
        }

        pop();

        // After Pop
        System.out.println("\nAfter popping out: ");
        for(int i=0; i<=top; i++)
            System.out.print(arr[i] + ", ");

    }

    static int displayMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("HEY! WELCOME.");
        System.out.println("=================");
        System.out.print("\nNumber of Elements you wanna enter in stack: ");
        int elements = input.nextInt();

        return elements;
    }

    static int getElement(int number) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter Element %02d: ", number);
        int element = input.nextInt();

        return element;
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
}
