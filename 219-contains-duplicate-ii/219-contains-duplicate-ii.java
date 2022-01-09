class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToLastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = numToLastIndex.get(nums[i]);
            if (lastIndex != null && (i - lastIndex) <= k) {
                return true;
            }
            numToLastIndex.put(nums[i], i);
        }
        return false;
    }
}