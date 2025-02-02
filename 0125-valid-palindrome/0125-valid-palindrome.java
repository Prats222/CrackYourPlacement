class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder normal = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                normal.append(Character.toLowerCase(ch));
            }
        }
        String rev = new StringBuilder(normal).reverse().toString();

        return normal.toString().equals(rev);
    }
}