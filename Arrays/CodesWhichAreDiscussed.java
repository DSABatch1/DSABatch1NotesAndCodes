Q1. Product of array except self (leetcode 238): 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prodFromStart = new int[nums.length]; // Array to store products from the start
        int[] prodFromEnd = new int[nums.length];   // Array to store products from the end

        // Calculate products from the start
        int productFromFirst = 1;
        for(int i = 0; i < nums.length; i++) {
            productFromFirst *= nums[i];
            prodFromStart[i] = productFromFirst;
        }
      
        // Calculate products from the end
        int productFromLast = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            productFromLast *= nums[i];
            prodFromEnd[i] = productFromLast;
        }

        int[] ans = new int[nums.length]; // Array to store the final results

        // Calculate the product of all elements except self for each element
        for(int i = 1; i < nums.length - 1; i++) {
            ans[i] = prodFromStart[i-1] * prodFromEnd[i+1];
        }

        // Special cases for the first and last elements
        ans[0] = prodFromEnd[1];
        ans[nums.length-1] = prodFromStart[nums.length-2];

        return ans;
    }
}

to convert the code to your specific language use :--> https://www.codeconvert.ai/free-converter

explanation :---

  Initialization:
prodFromStart: This array will store the cumulative product of elements from the beginning of the array up to each index.
prodFromEnd: This array will store the cumulative product of elements from the end of the array up to each index.
Calculate Products from the Start:

productFromFirst is initialized to 1.
As we iterate through the nums array from the beginning, we multiply productFromFirst by the current element and store the result in prodFromStart[i].
Initialize prodFromEnd Array:

prodFromEnd[nums.length - 1] is set to the last element of nums.
Calculate Products from the End:

productFromLast is initialized to 1.
As we iterate through the nums array from the end, we multiply productFromLast by the current element and store the result in prodFromEnd[i].
Calculate the Product of All Elements Except Self:

For each element in nums (except the first and last), ans[i] is calculated as the product of prodFromStart[i-1] and prodFromEnd[i+1], which effectively gives the product of all elements except the current element.
Handle Special Cases for the First and Last Elements:

ans[0] is set to prodFromEnd[1] since there are no elements to the left of the first element.
ans[nums.length - 1] is set to prodFromStart[nums.length - 2] since there are no elements to the right of the last element.





Q2 . Best time to buy and sell stocks (leetcode 121)

class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0; // Index to track the day to buy stock
        int sell = 0; // Index to track the day to sell stock
        int maxProfit = 0; // Variable to store the maximum profit

        // Loop through the prices array
        while(sell < prices.length) {
            int currentProfit = prices[sell] - prices[buy]; // Calculate the current profit
            maxProfit = Math.max(maxProfit, currentProfit); // Update maxProfit if currentProfit is higher

            // If the current sell price is less than the current buy price, update the buy index
            if(prices[sell] < prices[buy]) {
                buy = sell;
            }

            sell++; // Move to the next day
        }

        return maxProfit; // Return the maximum profit found
    }
}



Q3. Maximum sum subarray (leetcode 53) :--->
  

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer value or we can just set it to nums[0]
        int currentSum = 0; // Variable to store the current sum of the subarray

        // Loop through each element in the nums array
        for(int i : nums) {
            currentSum += i; // Add the current element to the current sum
            max = Math.max(max, currentSum); // Update max if the current sum is greater than max
            
            // If the current sum is negative, reset it to 0
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return max; // Return the maximum subarray sum found
    }
}
