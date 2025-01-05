class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length+1];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int maxi=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[maxi]){
                maxi=i;
            }
        }
        return dp[maxi]+1;
    }
}