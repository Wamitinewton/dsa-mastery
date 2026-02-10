package utils;

public class BubbleSort {

    public static void main(String[] args) {

        int[] myArray = {64, 34, 25, 12, 22, 11, 90, 5, 78};
        int n = myArray.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (myArray[j] > myArray[j + 1]) {
                    // Swap
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        for (int num : myArray) {
            System.out.print(num + " ");
        }
    }
}
