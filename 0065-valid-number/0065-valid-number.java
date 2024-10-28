class Solution {
    public boolean isNumber(String s) {
        // Remove leading and trailing spaces
        s = s.trim();
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasExp = false;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch >= '0' && ch <= '9') {
                // Valid digit
                hasNum = true;
            } else if (ch == '.') {
                // Only one dot is allowed and it should appear before an exponent
                if (hasDot || hasExp) return false;
                hasDot = true;
            } else if (ch == 'e' || ch == 'E') {
                // Only one exponent is allowed, and there must be a number before it
                if (hasExp || !hasNum) return false;
                hasExp = true;
                hasNum = false; // Reset for exponent to ensure digits after it
            } else if (ch == '+' || ch == '-') {
                // Sign is only allowed at the beginning or just after an exponent
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                // Invalid character
                return false;
            }
        }
        
        return hasNum;
    }
}
