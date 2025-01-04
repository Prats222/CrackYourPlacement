class Solution {
    public int waysToSplitArray(int[] nums) {
        long lefts=0,rights=0;
        for(int num:nums){
            rights+=num;
        }
        int valids=0;
        for(int i=0;i<nums.length-1;i++){
            lefts+=nums[i];
            rights-=nums[i];
            if(lefts>=rights){
                valids++;
            }
        }
        return valids;
    }
}