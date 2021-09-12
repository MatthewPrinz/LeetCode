class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            result[k] = nums[j];
            result[k+1] = nums[i + n];
            k += 2;
            j++;
        }
        return result;
    }
}