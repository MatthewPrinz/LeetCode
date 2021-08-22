class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                solution[0] = i;
                solution[1] = valueToIndex.get(target - nums[i]);
            }
            valueToIndex.put(nums[i], i);

        }
        return solution;
    }
}