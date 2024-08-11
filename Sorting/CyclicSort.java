
// CyclicSort.java
// Cyclic Sort implementation in Java

public class CyclicSort {

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int corr = arr[i] - 1;  // Calculate the correct index for arr[i]
            if (arr[i] != arr[corr]) {
                // Swap arr[i] with arr[corr]
                int temp = arr[i];
                arr[i] = arr[corr];
                arr[corr] = temp;
            } else {
                i++;  // Move to the next index
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        cyclicSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));  // Output will be [1, 2, 3, 4, 5]
    }
}
