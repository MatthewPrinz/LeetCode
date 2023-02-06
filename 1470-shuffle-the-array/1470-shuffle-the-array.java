class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n + n];
        int j = 0; // indexing Xs
        int k = n; // indexing Ys
        for (int i = 0; i < (n + n); i++) {
            if (i % 2 == 0) {
                result[i] = nums[j++];
            } else {
                result[i] = nums[k++];
                if (k >= (n + n)) {
                    break;
                }
            }
        }
        return result;
    }
}