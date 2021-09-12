class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j)
                    result++;
            }
        }
        return result;
    }
}