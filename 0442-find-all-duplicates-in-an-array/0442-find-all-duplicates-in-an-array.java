class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] freq= new int[nums.length+1];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<=nums.length;i++){
            if(freq[i]>1){
                arr.add(i);
            }
        }
        return arr;
    }
}