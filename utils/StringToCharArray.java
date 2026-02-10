package utils;

import java.util.Arrays;

/**
 * The toCharArray() method in Java is a built-in function of the String class that
 * converts a string into a new character array. Each character in the string
 * becomes an element in the resulting char array.
 */

public class StringToCharArray {

     public static void main(String[] args) {

        // Define a string
        String str = "Hello, World!";

        // Convert the String to a character array
        char[] myArray = str.toCharArray();

        // Print the character array
        System.out.println(Arrays.toString(myArray));
    }
}

