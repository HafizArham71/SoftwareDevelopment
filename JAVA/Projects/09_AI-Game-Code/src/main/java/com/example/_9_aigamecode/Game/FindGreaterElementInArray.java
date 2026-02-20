package com.example._9_aigamecode.Game;

public class FindGreaterElementInArray {
    static void main() {
        int[] arr = {1, 2, 6, 10, 3, 2, 7};

        int greater = arr[0];

        // Finding Greater Element in array
        for(int i=0; i<arr.length; i++)
                if(arr[i] > greater)
                    greater = arr[i];

        System.out.println(greater);
    }
}
