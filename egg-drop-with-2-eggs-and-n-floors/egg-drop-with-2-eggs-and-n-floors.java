class Solution {
    public static int NUM_EGGS = 2;
    public int twoEggDrop(int n) {
        int[][] dp = new int[NUM_EGGS+1][n+1];
        for (int eggs = 1; eggs <= n; eggs++) {
            dp[1][eggs] = eggs;
        }
        for (int eggs = 2; eggs <= NUM_EGGS; eggs++) {
            for (int floor = 1; floor <= n; floor++) {
                int min = Integer.MAX_VALUE;
                for (int dropFloor = 1; dropFloor <= floor; dropFloor++) {
                    int candidate = 1 + Math.max(dp[eggs-1][dropFloor-1], dp[eggs][floor-dropFloor]);
                    if (candidate < min) {
                        min = candidate;
                    }
                }
                dp[eggs][floor] = min;
            }
        }
        return dp[NUM_EGGS][n];
    }
}