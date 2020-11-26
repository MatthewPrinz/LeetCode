class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++)
        {
            char end = s[s.length-1-i];
            char begin = s[i];
            s[i] = end;
            s[s.length-i-1] = begin;
        }
    }
}
