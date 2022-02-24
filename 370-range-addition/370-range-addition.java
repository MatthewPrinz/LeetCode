class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // init variables
        int[] result = new int[length];
        
        for (int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int amount = update[2];
            result[startIndex] += amount;
            if (endIndex + 1 < length) {
                result[++endIndex] -= amount;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}