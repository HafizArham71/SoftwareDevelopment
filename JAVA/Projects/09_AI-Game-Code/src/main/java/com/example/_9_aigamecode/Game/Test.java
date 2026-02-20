package com.example._9_aigamecode.Game;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int arraySize = input.nextInt();

        Integer arr[] = new Integer[arraySize];

        for(int i=0; i<arraySize; i++) {

            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = input.nextInt();

        }

        System.out.println("Current Array: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // int arr[] = {4, 3, 3, 6, 7, 4, 4, 8};

        while(true) {
            System.out.println("1_ Add Element");
            System.out.println("2_ Remove Element");
            System.out.println("3_ Exit");

            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();

            if(choice == 1)
                addFunction(arr);
            else if (choice == 2)
                removeFunction(arr);
            else if(choice == 0)
                break;
            else
                System.out.println("Wrong Input");

        }

    }

    static void addFunction(Integer arr[]) {

        Integer arr1[] = new Integer[arr.length+1];
        int elemToAdd, indexToPlace;

        Scanner newInput = new Scanner(System.in);

        System.out.print("Enter Element to add: ");
        elemToAdd = newInput.nextInt();

        while(true) {
            System.out.print("Enter Index where to add: ");
            indexToPlace = newInput.nextInt();

            if(indexToPlace<arr.length && indexToPlace>=0)
                break;
        }

        for(int i=0; i<indexToPlace; i++) {

            arr1[i] = arr[i];

        }

        arr1[indexToPlace] = elemToAdd;


        int target = indexToPlace;

        for(int i=indexToPlace+1; i<arr1.length; i++) {

            arr1[i] = arr[target];
            target++;
        }

        arr = arr1;

        System.out.println("New Array: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    static void removeFunction(Integer arr[]) {

        Integer arr1[] = new Integer[arr.length-1];
        int indexToDelete;

        Scanner newInput = new Scanner(System.in);

        while(true) {
            System.out.print("Enter Index to remove: ");
            indexToDelete = newInput.nextInt();

            if(indexToDelete<arr.length && indexToDelete>=0)
                break;
        }

        // -----
        // 12345

        arr[indexToDelete] = null;

        for(int i=indexToDelete; i<arr.length-1; i++) {
            arr[i] = arr[i+1];
        }

        for(int i=0; i<arr1.length; i++)
            arr1[i] = arr[i];

        arr = arr1;

        System.out.println("New Array: ");
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
