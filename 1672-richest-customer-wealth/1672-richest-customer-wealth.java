class Solution {
    public int maximumWealth(int[][] accounts) {
        Map<Integer, Integer> customerToWealth = new HashMap<>();
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[0].length; j++) {
                if (customerToWealth.containsKey(i)) {
                    customerToWealth.put(i, customerToWealth.get(i) + accounts[i][j]);
                } else {
                    customerToWealth.put(i, accounts[i][j]);
                }
            }
        }
        int max = -1;
        for (Integer wealth : customerToWealth.values()) {
            if (wealth > max) {
                max = wealth;
            }
        }
        return max;
    }
}