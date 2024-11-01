class Solution {
    public String makeFancyString(String s) {
        char st = 'a';
        char end = 'z';
        char[] valid = new char[26];
        
        // Initialize valid array with characters from 'a' to 'z'
        for (int i = 0; i < 26; i++) {
            valid[i] = (char)(st + i);
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0; // Counter for consecutive characters
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Check if current character is valid and matches the required conditions
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch) {
                continue; // Skip adding if it forms three consecutive characters
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
