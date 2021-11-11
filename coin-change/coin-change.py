class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        INV = 2_000_000_000
        if coins == None or len(coins) == 0:
            return -1
        if amount == 0:
            return 0
        dp = [[0]*(amount+1) for i in range(len(coins))]
        for i in range(1, amount+1):
            dp[0][i] = INV if coins[0] > i else dp[0][i-coins[0]] + 1
            
        for row in range(1, len(coins)):
            for change in range(1, amount+1):
                dp[row][change] = min(INV, dp[row-1][change]) if coins[row] > change else min(dp[row-1][change], 1 + dp[row][change-coins[row]])
        return -1 if dp[len(coins) - 1][amount] >= 1_000_000_00 else dp[len(coins) - 1][amount]
                
        