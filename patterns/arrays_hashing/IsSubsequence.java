package patterns.arrays_hashing;

/**
 * LeetCode 392. Is Subsequence
 *
 * <p>Given two strings s and t, return true if s is a subsequence of t, or false otherwise.</p>
 *
 * <p>A subsequence of a string is a new string that is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).</p>
 *
 * <h3>Example 1:</h3>
 * <pre>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * </pre>
 *
 * <h3>Example 2:</h3>
 * <pre>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * </pre>
 *
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>0 <= s.length <= 100</li>
 *   <li>0 <= t.length <= 10^4</li>
 *   <li>s and t consist only of lowercase English letters.</li>
 * </ul>
 *
 * <h3>Follow up:</h3>
 * <p>Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to
 * check one by one to see if t has its subsequence. In this scenario, how would you change your code?</p>
 *
 * @author Newton
 * @since 2026-02-10
 */
public class IsSubsequence {

    /**
     * Approach 1: Recursive Solution
     *
     * <p>This method uses recursion to check if string s is a subsequence of string t by comparing
     * characters from the end of both strings and recursively checking smaller substrings.</p>
     *
     * <h4>Algorithm:</h4>
     * <ol>
     *   <li>Base Case 1: If m (length of s) is 0, s is an empty string, which is always a subsequence. Return true.</li>
     *   <li>Base Case 2: If n (length of t) is 0 but m is not, s cannot be a subsequence of an empty t. Return false.</li>
     *   <li>If the last characters of s and t match, recursively check the remaining parts (m-1, n-1).</li>
     *   <li>If the last characters don't match, move to the previous character in t (m, n-1) and check again.</li>
     * </ol>
     *
     * <h4>Example Walkthrough:</h4>
     * <pre>
     * s = "abc", t = "ahbgdc"
     *
     * Call 1: s[2]='c', t[5]='c' → match → recurse(2, 5)
     * Call 2: s[1]='b', t[4]='d' → no match → recurse(2, 4)
     * Call 3: s[1]='b', t[3]='g' → no match → recurse(2, 3)
     * Call 4: s[1]='b', t[2]='b' → match → recurse(1, 2)
     * Call 5: s[0]='a', t[1]='h' → no match → recurse(1, 1)
     * Call 6: s[0]='a', t[0]='a' → match → recurse(0, 0)
     * Call 7: m=0 → return true (base case)
     * </pre>
     *
     * <h4>Time Complexity:</h4>
     * <p><b>O(m + n)</b> - In the worst case, we might need to traverse through all characters of both strings.
     * Each character in t is visited at most once, and each character in s is matched at most once.</p>
     *
     * <h4>Space Complexity:</h4>
     * <p><b>O(m + n)</b> - Due to the recursive call stack. In the worst case, the recursion depth can be
     * m + n (when we need to traverse through most of both strings before finding matches).</p>
     *
     * @param s the subsequence string to check
     * @param t the main string to search in
     * @param m the current length/position in string s (initially s.length())
     * @param n the current length/position in string t (initially t.length())
     * @return true if s is a subsequence of t, false otherwise
     */
    static boolean isSubSequenceRecursion(String s, String t, int m, int n) {

        // Base cases
        if (m == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // If the last characters of two strings are matching
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return isSubSequenceRecursion(s, t, m - 1, n - 1);
        }

        // If last characters are not matching
        return isSubSequenceRecursion(s, t, m, n - 1);

    }

    /**
     * Approach 2: Two-Pointer Iterative Solution (Optimal)
     *
     * <p>This method uses two pointers to traverse both strings simultaneously. It's more efficient
     * than the recursive approach as it avoids the overhead of recursive calls and uses constant space.</p>
     *
     * <h4>Algorithm:</h4>
     * <ol>
     *   <li>Initialize two pointers: i for string s (subsequence) and j for string t (main string).</li>
     *   <li>Traverse both strings while both pointers are within bounds.</li>
     *   <li>If characters at both pointers match, increment i (move forward in subsequence).</li>
     *   <li>Always increment j (move forward in main string) regardless of match.</li>
     *   <li>If i reaches the end of s, all characters were found in order. Return true.</li>
     *   <li>If j reaches the end of t first, not all characters of s were found. Return false.</li>
     * </ol>
     *
     * <h4>Example Walkthrough:</h4>
     * <pre>
     * s = "abc", t = "ahbgdc"
     * i=0, j=0: s[0]='a', t[0]='a' → match → i=1, j=1
     * i=1, j=1: s[1]='b', t[1]='h' → no match → i=1, j=2
     * i=1, j=2: s[1]='b', t[2]='b' → match → i=2, j=3
     * i=2, j=3: s[2]='c', t[3]='g' → no match → i=2, j=4
     * i=2, j=4: s[2]='c', t[4]='d' → no match → i=2, j=5
     * i=2, j=5: s[2]='c', t[5]='c' → match → i=3, j=6
     * i=3 equals n (length of s), so return true
     * </pre>
     *
     * <h4>Time Complexity:</h4>
     * <p><b>O(n)</b> where n is the length of string t. We traverse the main string t at most once.
     * In the worst case, we check every character of t exactly once. The length of s (m) doesn't
     * significantly affect the complexity as we only move through s when we find matches.</p>
     *
     * <h4>Space Complexity:</h4>
     * <p><b>O(1)</b> - We only use a constant amount of extra space for the two pointers (i and j)
     * and a few integer variables. No additional data structures or recursive call stack is used.</p>
     *
     * <h4>Why This Approach is Better:</h4>
     * <ul>
     *   <li>No recursion overhead - saves memory and avoids potential stack overflow</li>
     *   <li>Constant space complexity instead of O(m+n)</li>
     *   <li>Single pass through the main string</li>
     *   <li>More intuitive and easier to understand</li>
     * </ul>
     *
     * @param s the subsequence string to check
     * @param t the main string to search in
     * @return true if s is a subsequence of t, false otherwise
     */
    static boolean isSubSequenceIterative(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;

        while (i < n && j < m) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == n;
    }

    static void main(){
        String s1 = "gksrek";
        String s2 = "geeksforgeeks";
        int m = s1.length();
        int n = s2.length();
        boolean res = isSubSequenceIterative(s1, s2);
        if (res)
            System.out.println("true");
        else
            System.out.println("false");
    }

}
