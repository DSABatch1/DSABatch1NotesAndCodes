
// CountingSort.java
// Counting Sort implementation in Java

public class CountingSort {

    public static int[] countingSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int[] freqArr = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            freqArr[nums[i] - min] += 1;
        }

        int[] ans = new int[nums.length];
        int k = 0;
        for (int i = 0; i < freqArr.length; i++) {
            while (freqArr[i] > 0) {
                ans[k] = i + min;
                freqArr[i]--;
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] sortedArr = countingSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(sortedArr));
    }
}
