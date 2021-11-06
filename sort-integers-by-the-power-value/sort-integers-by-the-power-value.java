class Solution {
    public int getKth(int low, int high, int k) {
        int[] dp = new int[high + 1];
        dp[1] = 1;
        for (int i = 1; i <= high; i++) {
            int j = i;
            int steps = 0;
            while (j > 1) {
                if (j < dp.length && dp[j] != 0) {
                    steps += dp[j];
                    break;
                }
                if (j % 2 == 0) 
                    j /= 2;
                 else 
                    j = (3*j) + 1;
                steps++;
            }
            dp[i] = steps;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < (high - low + 1); i++) {
            map.put(i + low, dp[i + low]);
        }
        List<Map.Entry<Integer, Integer>> results = new ArrayList<>(map.entrySet());
        Collections.sort(results, Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue)
              .thenComparingInt(Map.Entry<Integer, Integer>::getKey));
        return results.get(k-1).getKey();
    }
}