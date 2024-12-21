class Solution {
    public void moveZeroes(int[] nums) {
        // all zeroes in a dif arr, all non-zero in dif ary, and combine. # not space effecient as 2 arr 
        // int[] zero = new int[nums.length];
        // int nonz[]= new int[nums.length];

        // int zeroI = 0; int nonzI=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         zero[zeroI++]=nums[i];
        //     }else{
        //         nonz[nonzI++]=nums[i];
        //     }
        // }
        // int ind = 0;
        // for(int i=0;i<nonzI;i++){
        //     nums[ind++]=nonz[i];
        // }
        // for(int i=0;i<zeroI;i++){
        //     nums[ind++]=zero[i];
        // }
        int insertposi=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertposi++]=nums[i];
            }
        }
        while(insertposi<nums.length){
            nums[insertposi++]=0;
        }
    }
}