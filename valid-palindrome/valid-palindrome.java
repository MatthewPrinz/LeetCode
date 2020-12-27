class Solution {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        if (sl.length() == 0)
            return true;
        int beginPos = 0;
        int endPos = sl.length()-1;
        while (beginPos < endPos)
        {
            if (!Character.isLetterOrDigit((sl.charAt(beginPos))) || !Character.isLetterOrDigit(sl.charAt(beginPos)))
            {
                beginPos++;
                continue;
            }
            if (!Character.isLetterOrDigit((sl.charAt(endPos))) || !Character.isLetterOrDigit(sl.charAt(endPos)))
            {
                endPos--;
                continue;
            }
            if (sl.charAt(beginPos) != sl.charAt(endPos))
                return false;
            beginPos++;
            endPos--;
        }
    return true;
    }
}
