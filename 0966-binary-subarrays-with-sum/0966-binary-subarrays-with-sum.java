class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1; // Initialize to handle subarrays starting from index 0

        for (int num : nums) {
            sum += num; // Update the running sum

            // Check if there exists a prefix sum such that sum - prefixSum = goal
            if (sum >= goal) {
                count += prefixSum[sum - goal];
            }

            // Update the prefix sum count
            prefixSum[sum]++;
        }

        return count;
    }
}