class Solution {
    public int getMaximumGenerated(int n) {
        int max = 0;
        if (n == 0)
            return max;
        int[] dp = new int[n+1];
        max = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i/2] + dp[(i/2) + 1] * (i % 2);
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}