class Solution {
    public boolean validPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        boolean result0 = true;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                result0 = false;
                break;
            }
            else {
                begin++;
                end--;
            }
        }
        boolean result1 = checkPalindrome(new StringBuilder(s).deleteCharAt(begin).toString());
        boolean result2 = checkPalindrome(new StringBuilder(s).deleteCharAt(end).toString());
        return result0 || result1 || result2;
    }
    
    boolean checkPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }
}