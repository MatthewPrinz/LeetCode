class Solution {
    public static int NUM_EGGS = 2;
    public int twoEggDrop(int n) {
        int[][] dp = new int[NUM_EGGS+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= NUM_EGGS; i++) {
            for (int j = 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int candidate = 1 + Math.max(dp[i-1][k-1], dp[i][j-k]);
                    if (candidate < min) {
                        min = candidate;
                    }
                }
                dp[i][j] = min;
            }
        }
        printMat(dp);
        return dp[NUM_EGGS][n];
    }
    
    void printMat(int[][] m) {
        for (int[] r : m) {
            System.out.println(Arrays.toString(r));
        }
    }
}