class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0; // To count the number of odd numbers encountered
        int start = 0;    // Start index of the current subarray
        int niceCount = 0; // Count of nice subarrays
        int[] prefixCount = new int[nums.length + 1]; // To store the count of subarrays with odd numbers

        prefixCount[0] = 1; // There is one way to have zero odd numbers

        for (int i = 0; i < nums.length; i++) {
            // Increment oddCount if the current number is odd
            if (nums[i] % 2 != 0) {
                oddCount++;
            }

            // If we have more than k odd numbers, count the valid subarrays
            if (oddCount >= k) {
                niceCount += prefixCount[oddCount - k];
            }

            // Update prefixCount for the current oddCount
            prefixCount[oddCount]++;
        }

        return niceCount;
    }
}
