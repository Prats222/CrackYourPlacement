class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1]; // Ensure the result array has the correct size
        
        for (int i = 0; i <= n - k; i++) { // Iterate only for valid starting indices
            boolean isConsecutive = true;
            int max = nums[i]; // Track the maximum value in the current subarray
            
            // Check if the subarray nums[i..(i + k - 1)] is sorted and consecutive
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) { // Check consecutive condition
                    isConsecutive = false;
                    break;
                }
                max = Math.max(max, nums[j + 1]); // Update max if necessary
            }
            
            res[i] = isConsecutive ? max : -1; // Store the result for the current subarray
        }
        
        return res;
    }
}
