class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int y = 1;
        for (int i = 0; i < s.length(); i++) {
            int k = 0;
            for (int j = y; j < s.length(); j++) {
                if (s.charAt(k) != s.charAt(j)) {
                    dp[k][j] = Math.max(dp[k + 1][j], dp[k][j - 1]);
                } else {
                    dp[k][j] = 2 + dp[k + 1][j - 1];
                }
                k++;
            }
            y++;
        }
        return dp[0][s.length() - 1];
    }
}