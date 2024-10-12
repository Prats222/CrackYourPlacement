class Solution {
    public String longestPrefix(String s) {
        char c[]=s.toCharArray();
        int dp[]=new int[c.length];
        int n=c.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(c[i]==c[j])
             dp[j]=++i;
            else {
                while(i>0){
                    i=dp[i-1];
                    if(c[i]==c[j]){
                        dp[j]=++i;
                        break;
                    }
                }
            }
        }

        return s.substring(0,dp[c.length-1]);


    }
}