class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd-length strings can't be valid
        
        int openBalance = 0, flexible = 0;
        
        // Left to Right Check
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                openBalance += s.charAt(i) == '(' ? 1 : -1;
            } else {
                flexible++;
            }
            if (openBalance + flexible < 0) return false; // Too many ')'
        }
        
        int closeBalance = 0;
        flexible = 0;
        
        // Right to Left Check
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                closeBalance += s.charAt(i) == ')' ? 1 : -1;
            } else {
                flexible++;
            }
            if (closeBalance + flexible < 0) return false; // Too many '('
        }
        
        return true;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen("", 0, 0, n, ans);
        return ans;
    }
    
    public void gen(String curr, int open, int close, int total, List<String> ans) {
        if (curr.length() == 2 * total) {
            ans.add(curr);
            return;
        }
        if (open < total) {
            gen(curr + '(', open + 1, close, total, ans);
        }
        if (close < open) {
            gen(curr + ')', open, close + 1, total, ans);
        }
    }
}
