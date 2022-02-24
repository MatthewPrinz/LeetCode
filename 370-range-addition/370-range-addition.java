class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // init variables
        int[] result = new int[length];
        
        // algorithm
        for (int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int amount = update[2];
            for (int i = startIndex; i <= endIndex; i++) {
                result[i] += amount;
            }
        }
        return result;
    }
}