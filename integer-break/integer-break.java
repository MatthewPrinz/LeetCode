class Solution {
    public int integerBreak(int n) {
        int[][] dp = new int[n][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - i >= 0)
                    dp[i][j] = Math.max(i * dp[i][j-i], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n-1][n];
    }
}