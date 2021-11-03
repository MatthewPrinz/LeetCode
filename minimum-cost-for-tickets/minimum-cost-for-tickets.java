class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length - 1];
        int[] dp = new int[len + 1];
        boolean[] going = new boolean[len + 1];
        for (int n : days) {
            going[n] = true;
        }
        dp[1] = costs[0];
        for (int i = 1; i < dp.length; i++) {
            if (!going[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(i-7, 0)] + costs[1], dp[Math.max(i-30, 0)] + costs[2]));
        }
        return dp[len];
    }
}