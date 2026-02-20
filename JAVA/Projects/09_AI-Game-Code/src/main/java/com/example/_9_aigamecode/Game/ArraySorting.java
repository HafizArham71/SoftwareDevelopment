package com.example._9_aigamecode.Game;

public class ArraySorting {
    static void main() {
        int[] arrToSort = {2, 7, 3, 1, 9, 4, 6};

        arrToSort = sortArray(arrToSort);

        iterateArray(arrToSort);

    }

    static int[] sortArray(int[] arr) {

        int[] newArr = new int[arr.length];

        int smallest = arr[0];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i] < arr[j]) {
                    smallest = arr[i];
                }else
                    smallest = arr[j];
            }
            newArr[i] = smallest;
        }
        return newArr;
    }

    static void iterateArray(int[] arr) {

        System.out.print("[");
        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1)
                System.out.print(arr[i] + "]");
            else
                System.out.print(arr[i] + ", ");
        }
    }
}
