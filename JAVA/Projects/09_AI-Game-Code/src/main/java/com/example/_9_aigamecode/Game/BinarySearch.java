package com.example._9_aigamecode.Game;

public class BinarySearch {
    static void main() {
        int[] arrayForBinarySearch = new int[1_000_000_000];

        for (int i = 0; i < arrayForBinarySearch.length; i++)
            arrayForBinarySearch[i] = i + 1;

//        for (int i = 0; i < arrayForBinarySearch.length; i++)
//            System.out.println(arrayForBinarySearch[i]);

        // BinarySearch [key = target]
        int iterationCounter = 0;
        int low = 0, high = arrayForBinarySearch.length - 1, mid = (low + high) / 2, target = 45;
        while (low <= high) {
            if (arrayForBinarySearch[mid] == target) {
                System.out.printf("-> Cycle_%02d: \n", iterationCounter);
                System.out.printf("    Low: %d, Mid: %d, High: %d\n", low, mid, high);
                System.out.println(arrayForBinarySearch[mid]);
                break;
            } else if (arrayForBinarySearch[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
                System.out.printf("-> Cycle_%02d: \n", iterationCounter++);
                System.out.printf("    Low: %d, Mid: %d, High: %d\n", low, mid, high);
            } else {
                low = mid + 1;
                mid = (low + high) / 2;
                System.out.printf("-> Cycle_%02d: \n", iterationCounter++);
                System.out.printf("    Low: %d, Mid: %d, High: %d\n", low, mid, high);
            }

        }
    }
}
