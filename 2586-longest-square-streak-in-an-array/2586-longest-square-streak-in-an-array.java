class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(int num:nums){
            set.add((long) num);
        }
        Arrays.sort(nums);
        int res=-1;
        for(int num:nums){
            Long temp = (long) num;
            int count=1;
            while(set.contains(temp*temp)){
                count++;
                temp=temp*temp;
                res=Math.max(res,count);
            }
        }
        return res;
    }
}