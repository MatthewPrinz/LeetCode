class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = numToIndex.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            numToIndex.put(nums[i], indices);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = numToIndex.get(nums[i]);
            for (int j : indices) {
                if (j != i && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}