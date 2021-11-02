class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        int maxLen = -1;
        String longestPal = null;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if ((j - i) > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    longestPal = s.substring(i, j);
                }
            }
        }
        return longestPal;  
}
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}