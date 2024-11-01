class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(char c='A';c<='Z'; c++){
            int i=0,j=0, replace=0;
            while(j<s.length()){
                if(s.charAt(j)==c){
                    j++;
                }else if(replace<k){
                    j++;
                    replace++;
                }else if(s.charAt(i)==c){
                    i++;
                }else{
                    i++;
                    replace--;
                }
                ans=Math.max(ans,j-i);
            }
        }
        return ans;
    }
}