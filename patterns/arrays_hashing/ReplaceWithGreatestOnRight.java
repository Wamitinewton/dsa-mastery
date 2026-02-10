package patterns.arrays_hashing;

import utils.PrintArray;

/**
 * LeetCode 1299: Replace Elements with Greatest Element on Right Side
 *
 * <p>Problem Statement:</p>
 * Given an array arr, replace every element in that array with the greatest element
 * among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 *
 * <p>Example 1:</p>
 * <pre>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * </pre>
 *
 * <p>Example 2:</p>
 * <pre>
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * </pre>
 *
 * <p>Constraints:</p>
 * <ul>
 *   <li>1 <= arr.length <= 10^4</li>
 *   <li>1 <= arr[i] <= 10^5</li>
 * </ul>
 */
public class ReplaceWithGreatestOnRight {

    /**
     * Brute Force Approach: Replace each element with the greatest element on its right.
     *
     * <p>Algorithm:</p>
     * <ol>
     *   <li>For each element at index i, scan all elements to the right (indices i+1 to n-1)</li>
     *   <li>Find the maximum value among all elements to the right</li>
     *   <li>Replace the current element with this maximum value</li>
     *   <li>If no elements exist to the right, replace with -1</li>
     * </ol>
     *
     * <p>Time Complexity: O(n²)</p>
     * <ul>
     *   <li>Outer loop runs n times (for each element)</li>
     *   <li>Inner loop runs up to n-1 times in worst case</li>
     *   <li>Total operations: n × (n-1)/2 ≈ O(n²)</li>
     * </ul>
     *
     * <p>Space Complexity: O(1)</p>
     * <ul>
     *   <li>Only uses a constant amount of extra space (max_value variable)</li>
     *   <li>Modifies the array in-place</li>
     *   <li>No additional data structures are used</li>
     * </ul>
     *
     * <p>Drawbacks:</p>
     * <ul>
     *   <li>Inefficient for large arrays due to nested loops</li>
     *   <li>Performs redundant comparisons</li>
     * </ul>
     *
     * @param arr the input array to be modified
     * @param n the length of the array
     */
    static int[] replaceWithGreatestRightBruteForce(int[] arr, int n)
    {
        for (int i = 0; i<n; i++) {

            int max_value = -1;
            for (int j = i+1; j<n; j++) {
                if (arr[j] > max_value) {
                    max_value = arr[j];
                }
            }
            arr[i] = max_value;
        }

        return arr;
    }

    /**
     * Optimal Approach: Replace each element with the greatest element on its right
     * using a single pass from right to left.
     *
     * <p>Algorithm:</p>
     * <ol>
     *   <li>Initialize max_from_right with the last element of the array</li>
     *   <li>Set the last element to -1 (as there are no elements to its right)</li>
     *   <li>Traverse the array from right to left (from second-to-last to first element)</li>
     *   <li>For each element:
     *     <ul>
     *       <li>Store the current element in a temporary variable</li>
     *       <li>Replace the current element with max_from_right</li>
     *       <li>Update max_from_right if the stored value is greater</li>
     *     </ul>
     *   </li>
     * </ol>
     *
     * <p>Key Insight:</p>
     * By traversing from right to left, we maintain the maximum value seen so far from the right.
     * This eliminates the need to search for the maximum each time.
     *
     * <p>Example Walkthrough:</p>
     * <pre>
     * Input: [16, 17, 4, 3, 5, 2]
     *
     * Step 1: max_from_right = 2, arr = [16, 17, 4, 3, 5, -1]
     * Step 2: i=4, temp=5, arr[4]=2, max_from_right=5  -> [16, 17, 4, 3, 2, -1]
     * Step 3: i=3, temp=3, arr[3]=5, max_from_right=5  -> [16, 17, 4, 5, 2, -1]
     * Step 4: i=2, temp=4, arr[2]=5, max_from_right=5  -> [16, 17, 5, 5, 2, -1]
     * Step 5: i=1, temp=17, arr[1]=5, max_from_right=17 -> [16, 5, 5, 5, 2, -1]
     * Step 6: i=0, temp=16, arr[0]=17, max_from_right=17 -> [17, 5, 5, 5, 2, -1]
     *
     * Output: [17, 5, 5, 5, 2, -1]
     * </pre>
     *
     * <p>Time Complexity: O(n)</p>
     * <ul>
     *   <li>Single traversal of the array from right to left</li>
     *   <li>Each element is visited exactly once</li>
     *   <li>Constant time operations (comparison and assignment) at each step</li>
     * </ul>
     *
     * <p>Space Complexity: O(1)</p>
     * <ul>
     *   <li>Only uses two extra variables: max_from_right and temp</li>
     *   <li>Space used does not depend on input size</li>
     *   <li>Modifies the array in-place without additional data structures</li>
     * </ul>
     *
     * <p>Advantages over Brute Force:</p>
     * <ul>
     *   <li>Significantly faster: O(n) vs O(n²)</li>
     *   <li>No nested loops or redundant comparisons</li>
     *   <li>Optimal solution that cannot be improved asymptotically</li>
     * </ul>
     *
     * @param arr the input array to be modified
     */
    static int[] replaceWithGreatestRightOptimal(int[] arr) {

        int size = arr.length;

        int max_from_right = arr[size - 1];
        arr[size - 1] = -1;

        for (int i = size -2; i>=0; i--) {

            int temp = arr[i];
            arr[i] = max_from_right;

            if (temp > max_from_right) {
                max_from_right = temp;
            }
        }
        return arr;
    }

    /**
     * Main method to demonstrate and test the Replace Elements with Greatest on Right solution.
     *
     * <p>Tests both the brute force and optimal approaches with sample input.</p>
     * The brute force approach is commented out by default to showcase the optimal solution.
     */
    static void main() {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int n = arr.length;

//        replaceWithGreatestRightBruteForce(arr, n);

        PrintArray.printArray(replaceWithGreatestRightOptimal(arr));
    }
}
