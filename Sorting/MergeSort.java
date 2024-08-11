
// MergeSort.java
// Merge Sort implementation in Java

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // Storing elements in the temporary array in a sorted manner
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // If elements on the left half are still left
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // If elements on the right half are still left
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Transferring all elements from temporary to arr
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid); // Left half
        mergeSort(arr, mid + 1, high); // Right half
        merge(arr, low, mid, high); // Merging sorted halves
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
