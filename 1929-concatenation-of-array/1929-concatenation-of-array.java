class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length + nums.length;
        int[] result = new int[len];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i + nums.length] = nums[i];
        }
        return result;
    }
}