class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int prevRun = 0, curRun = 1, result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i))
                curRun++;
            else {
                prevRun = curRun;
                curRun = 1;
            }
            if (prevRun >= curRun)
                result++;
        }
        return result;
    }
}