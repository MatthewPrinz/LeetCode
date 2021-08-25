class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = valueToIndex.get(target - nums[i]);
            }
            valueToIndex.put(nums[i], i);
        }
        return result;
    }
}