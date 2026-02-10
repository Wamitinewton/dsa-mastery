package playground;

/**
 * An array is a contiguous block of memory that stores multiple values of the same type.
 * Each element is accessed using an index, which represents its position in the array.
 */
public class ArrayOperations {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        // Size of the array
        int n = arr.length;

        // Traverse and print array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
