class Solution {
    public static final int INV = 2000000000;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        if (amount == 0)
            return 0;
        
        int[][] mat = new int[coins.length][amount+1];
        
        for (int row = 0; row < coins.length; row++) {
            for (int change = 1; change < amount+1; change++) {
                if (row == 0) {
                    if (coins[row] > change) {
                        mat[row][change] = INV;
                    } else {
                        mat[row][change] = mat[row][change - coins[row]] + 1;
                    }
                } else {
                    if (coins[row] > change) {
                        mat[row][change] = Math.min(INV, mat[row-1][change]);
                    } else {
                        mat[row][change] = Math.min(mat[row-1][change], 
                                                    1 + 
                                                    mat[row][change-coins[row]]);
                    }
                }
            }
        }
        return mat[coins.length-1][amount] >= 1000000000 ? -1 : mat[coins.length-1][amount];
    }
}