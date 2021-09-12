class Solution {
    public int balancedStringSplit(String s) {
        int result = 0;
        int countRs = 0;
        int countLs = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                countRs++;
            } else {
                countLs++;
            }
            if (countRs == countLs) {
                countRs = countLs = 0;
                result++;
            }   
        }
        return result;
    }
}