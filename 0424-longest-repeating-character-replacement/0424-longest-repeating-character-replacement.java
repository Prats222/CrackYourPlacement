class Solution {
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int res = 0; 
        int max = 0;
        int start=0;
        for(int end=0;end<s.length();end++){
            arr[s.charAt(end)-'A']++;

            max=Math.max(max,arr[s.charAt(end)-'A']);

            if(end-start+1 - max > k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(res,end-start+1);
        }
        return res;
    }
}