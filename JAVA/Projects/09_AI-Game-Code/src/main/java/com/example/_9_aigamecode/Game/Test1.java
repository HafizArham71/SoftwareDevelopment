package com.example._9_aigamecode.Game;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("=========== ARRAYS OPERATIONS ==========");
        System.out.println("-> Create Array:- ");
        Integer[] array = createArray();
        currentArray(array);
        displayOperations(array);
    }

    static void displayOperations(Integer[] arr) {

        Scanner newInput = new Scanner(System.in);

        while(true) {
            System.out.println("-> Operations:- ");
            System.out.println("1_ Add Element in Array");
            System.out.println("2_ Remove Element from Array");
            System.out.println("0_ Exit\n");

            System.out.print("Enter your Choice: ");
            int choice = newInput.nextInt();

            if(choice == 1) {
                arr = addElement(arr);
                currentArray(arr);
            }
            else if(choice == 2) {
                arr = removeElement(arr);
                currentArray(arr);
                System.out.println("Remove Operation");
            }
            else if(choice == 0)
                break;
            else
                System.out.println("Wrong choice");

        }
    }

    static Integer[] addElement(Integer[] arr) {

        Integer[] newArr = new Integer[arr.length+1];

        Scanner input = new Scanner(System.in);

        System.out.print("Give me the element to add in array: ");
        int elemToAdd = input.nextInt();

        System.out.print("Give me the index number where to add the element in array: ");
        int elemIndex = input.nextInt();

        // [1, 2, 3, 4, 5]
        for(int i=0; i<newArr.length; i++) {
            if(i == elemIndex) {
                newArr[i] = elemToAdd;
            }else if(i>elemIndex) {
                newArr[i] = arr[i-1];
            }
            else
                newArr[i] = arr[i];
        }
        return newArr;

    }

    static Integer[] removeElement(Integer[] arr) {
        Integer[] newArr = new Integer[arr.length-1];

        Scanner input = new Scanner(System.in);

        System.out.print("Enter index to remove: ");
        int indexToRemove = input.nextInt();

        int helper = 0;
        for(int i=0; i<arr.length; i++) {    // [1, 2, 3, 9, 4, 5]
            if(i == indexToRemove) {    // [1, 2, 3, 4, ]
                continue;
            }else if(i>indexToRemove) {
                newArr[i-1] = arr[i];
            }
            else
                newArr[i] = arr[i];
        }
        return newArr;
    }

    static Integer[] createArray() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int arraySize = input.nextInt();

        Integer[] arr = new Integer[arraySize];

        for(int i=0; i<arraySize; i++) {
            System.out.printf("Enter array element %02d: ", i+1);
            arr[i] = input.nextInt();
        }

        return arr;
    }

    static void currentArray(Integer[] arr) {
        System.out.print("Current Array: ");
        System.out.print("[");
        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

}
