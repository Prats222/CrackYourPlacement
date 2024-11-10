class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Hash Map to Store Results: We use a hash map (nextGreater) where the key is an element in nums2, and the value is its next greater element.
        HashMap<Integer,Integer> nextG = new HashMap();
        Stack<Integer> st = new Stack<>();
        for(int num:nums2){
            while(!st.isEmpty() && st.peek()<num){
                nextG.put(st.pop(),num); // while rup runs till we dont get the greater elemnt, once we get it , it is put on hashmap as key is elemnt and its output is the nextG element.
            }
            st.push(num);// we push this current nextG elemnt to stack.
        }
        int res[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=nextG.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}