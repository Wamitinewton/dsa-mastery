package utils;

public class SelectionSort {

    static void selectionSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // Assume the current index is the minimum
            int min_idx = 1;

            // Iterate through the unsorted elements
            // to find the index of the minimum element
            for (int j = i +1; j< n; j++) {
                if (arr[j] < arr[min_idx]) {

                    // Update min_idx if a smaller element is found
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.print("Original array: ");
        PrintArray.printArray(arr);
        selectionSort(arr);

        System.out.print("Sorted array: ");
        PrintArray.printArray(arr);
    }
}

