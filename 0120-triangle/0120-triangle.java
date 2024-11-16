class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Initialize dp array with the same dimensions as the triangle
        int[][] dp = new int[n][n];
        
        // Fill the last row of dp with the values from the last row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        
        // Build the dp array from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Pick current and move straight down
                int pick = triangle.get(i).get(j) + dp[i + 1][j];
                // Pick current and move down-right
                int notPick = triangle.get(i).get(j) + dp[i + 1][j + 1];
                // Store the minimum of the two in dp[i][j]
                dp[i][j] = (pick < notPick) ? pick : notPick;
            }
        }
        
        // The top element contains the minimum path sum
        return dp[0][0];
    }
}
