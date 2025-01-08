import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray(); // Convert the current word to a char array
            for (String word : words) {
                if (!word.equals(words[i]) && word.contains(String.valueOf(ch))) { 
                    ans.add(words[i]);
                    break; // To avoid duplicates
                }
            }
        }
        return ans;
    }
}
