class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(j);                
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[triangle.size() - 1][i]);
        }
        return min;
    }
}