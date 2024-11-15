class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;

        // Find the longest non-decreasing prefix
        while (left < right && arr[left] <= arr[left + 1]) left++;

        // If the array is already sorted
        if (left == right) return 0;

        // Find the longest non-decreasing suffix
        while (right > 0 && arr[right - 1] <= arr[right]) right--;

        // Minimum of removing the prefix or suffix
        int result = Math.min(n - left - 1, right);

        // Check merging prefix and suffix
        for (int i = 0; i <= left; i++) {
            if (arr[i] <= arr[right]) {
                result = Math.min(result, right - i - 1);
            } else if (right < n - 1) {
                right++;
            }
        }
        return result;
    }
}
