class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n == 1)
            return dp[1];
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = 0;
            sum += dp[i - 1] * 2;
            for (int j = 1; j < (i-1); j++) {
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}