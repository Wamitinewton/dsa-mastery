package patterns.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram Problem
 * <p>
 * Given two strings, determine if they are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example:
 * Input: "listen", "silent" → Output: true
 * Input: "hello", "world" → Output: false
 */
public class ValidAnagram {

    /**
     * Approach 1: Brute Force (Bubble Sort)
     * Time Complexity: O(n^2) - due to bubble sort
     * Space Complexity: O(n) - for character arrays
     */
    public boolean isAnagramBubbleSort(String s1, String s2) {
        // If lengths differ, can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert to character arrays and sort using bubble sort
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        bubbleSort(s1Array);
        bubbleSort(s2Array);

        // Compare sorted arrays
        for (int i = 0; i < s1Array.length; i++) {
            if (s1Array[i] != s2Array[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method for bubble sort
     */
    private void bubbleSort(char[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Approach 2: Optimal (Built-in Sorting)
     * Time Complexity: O(n log n) - due to built-in sort
     * Space Complexity: O(n) - for character arrays
     */
    public boolean isAnagramSorting(String s1, String s2) {
        // If lengths differ, can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert to character arrays and sort
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare sorted arrays
        return Arrays.equals(s1Array, s2Array);
    }

    /**
     * Approach 3: Most Optimal (HashMap)
     * Time Complexity: O(n) - single pass through both strings
     * Space Complexity: O(n) - for the hashmap
     */
    public boolean isAnagramHashMap(String s1, String s2) {
        // If lengths differ, can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Store character frequencies
        Map<Character, Integer> charCount = new HashMap<>();

        // Increase count for characters in s1
        for (char ch : s1.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Decrease count for characters in s2
        for (char ch : s2.toCharArray()) {
            if (!charCount.containsKey(ch)) {
                return false;
            }
            charCount.put(ch, charCount.get(ch) - 1);
        }

        // Check if all counts are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 4: Alternative Optimal (Character Frequency Array)
     * Time Complexity: O(n) - single pass through both strings
     * Space Complexity: O(1) - fixed size array (assuming lowercase English letters)
     * <p>
     * Note: Only works for lowercase English letters
     */
    public boolean isAnagramFrequencyArray(String s1, String s2) {
        // If lengths differ, can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Array to store frequency of characters (a-z)
        int[] charFreq = new int[26];

        // Increase count for s1, decrease for s2
        for (int i = 0; i < s1.length(); i++) {
            charFreq[s1.charAt(i) - 'a']++;
            charFreq[s2.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int freq : charFreq) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }

    static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();

        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Testing with: \"" + s1 + "\" and \"" + s2 + "\"");
        System.out.println("Bubble Sort approach: " + va.isAnagramBubbleSort(s1, s2));
        System.out.println("Sorting approach: " + va.isAnagramSorting(s1, s2));
        System.out.println("HashMap approach: " + va.isAnagramHashMap(s1, s2));
        System.out.println("Frequency Array approach: " + va.isAnagramFrequencyArray(s1, s2));

        System.out.println("\nTesting with: \"hello\" and \"world\"");
        System.out.println("HashMap approach: " + va.isAnagramHashMap("hello", "world"));
    }
}

