class Solution {
    public int minimumLength(String s) {
        int totfreq[] = new int[26];
        int totlen=0;
        for(char c:s.toCharArray()){
            totfreq[c-'a']++;
        }
        for(int freq:totfreq){
            if(freq==0) continue;
            if(freq%2==0){
                totlen+=2;
            }else{
                totlen+=1;
            }
        } 
        return totlen;
    }
}
//Use an array of size 26 to count occurrences of each character.
// For each character frequency:
// If the frequency is even, add 2 to the total length.
// If the frequency is odd, add 1 to the total length.

// For even frequencies, characters can be removed in pairs.
// For odd frequencies, one character remains.