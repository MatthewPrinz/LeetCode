class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        result ^= i;
        return result;
    }
}