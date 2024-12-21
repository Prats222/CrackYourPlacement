class Solution {
    public int missingNumber(int[] nums) {
        // int n=nums.length;
        // int freq[] = new int[n+1];
        // for(int i=0;i<n;i++){
        //     freq[nums[i]]++;
        // }
        // for(int i=0;i<freq.length;i++){
        //     if(freq[i]==0){
        //         return i;
        //     }
        // }
        // return 0;
        int n=nums.length;
        int sum = n*(n+1)/2;
        for(int num:nums){
            sum-=num;
        }
        return sum;
    }
}