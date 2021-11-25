class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                boolean result = false;
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    result = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    result = dp[i][j - 2] /* 0 matches */ || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') /* one or more matches */ ? dp[i - 1][j] : false);
                }
                dp[i][j] = result;
            }
        }
        return dp[s.length()][p.length()];
    }
}