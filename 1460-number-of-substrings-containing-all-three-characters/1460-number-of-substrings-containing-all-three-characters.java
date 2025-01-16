class Solution {
    public int numberOfSubstrings(String s) {
       int count[] ={0,0,0} , res=0, start=0, n =s.length();
       for(int end=0;end<n;end++){
       count[s.charAt(end)-'a']++;

       while(count[0]>0 && count[1]>0 && count[2]>0){
        count[s.charAt(start)-'a']--;
        start++;
       }
        res+=start;
       }
       return res;
    }
}
// Input: s = "abcabc"

// j = 0, count = [1, 0, 0], no valid substring yet.
// j = 1, count = [1, 1, 0], no valid substring yet.
// j = 2, count = [1, 1, 1], valid substring found:
// Shrink window: i = 1, count = [0, 1, 1].
// Add i = 1 to res.
// j = 3, count = [1, 1, 1], valid substrings:
// Shrink window: i = 2, count = [1, 0, 1].
// Add i = 2 to res.
// Continue similarly, adding all valid substrings to res.
// Output: res = 10.