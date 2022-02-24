class Solution {
    public int[] finalPrices(int[] prices) {
        // initialize result array
        int[] result = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (j == prices.length) {
                    break;
                }
                if (prices[j] <= prices[i]) {
                    price -= prices[j];
                    break;
                }
            }
            result[i] = price;
        }
        return result;
    }
}