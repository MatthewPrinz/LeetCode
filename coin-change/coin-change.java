class Solution {
    public static final int INV = 2000000000;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        if (amount == 0)
            return 0;
        
        int[][] mat = new int[coins.length][amount+1];
        // Set up first row (base case)
        for (int i = 1; i < amount + 1; i++) {
            mat[0][i] = coins[0] > i ? mat[0][i] = INV : mat[0][i - coins[0]] + 1;
        }
        
        // Create the rest of the matrix
        for (int row = 1; row < coins.length; row++) {
            for (int change = 1; change < amount+1; change++) {
                mat[row][change] = coins[row] > change ? Math.min(INV, mat[row-1][change]) : Math.min(mat[row-1][change], 1 + mat[row][change-coins[row]]);
                }
            }

        return mat[coins.length-1][amount] >= 1000000000 ? -1 : mat[coins.length-1][amount];
    }
}