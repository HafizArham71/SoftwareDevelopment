
package com.example._3_pingponggame.Class04;

// I did it using java
public class Test {

    static void main(String[] args) {
        System.out.println(reverseWords("Hello Everyone! My name is Hafiz Arham Mujahid. I am from Lahore. I recently comleted my Semester 2 at COMSATS University Lahore. After getting some holiday, i decided to do short short courses as skills. Fortunately, a CM course related to AL & ML came into view during my search, i applied for it and got selected. Now, I am here."));
    }


    public static String reverseWords(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        int startIndex = 0;
        char character;

        for(int i=0; i<str.length(); i++) {
            character = str.charAt(i);
            if(character == ' ' || i == str.length()-1) {
                if(i == str.length()-1)
                    stringBuilder.append(reverseString(str, startIndex, i));

                else {
                    stringBuilder.append(reverseString(str, startIndex, i - 1));
                    stringBuilder.append(" ");
                    startIndex = i + 1;
                }
            }
        }

        return stringBuilder.toString();
    }

    private static String reverseString(String str, int startIndex, int endIndex) {
        char[] charArr = new char[endIndex-startIndex+1];
        int index = 0;
        for(int i=endIndex; i>=startIndex; i--) {
            charArr[index++] = str.charAt(endIndex--);
        }
        String string = new String(charArr);
        return string;
    }
}
