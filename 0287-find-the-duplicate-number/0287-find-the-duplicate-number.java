class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int count=0;
        int freq[] = new int[n+1];
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(freq[i]>1){
            count=i;
            }
        }
        return count;
    }
}