class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
        return numsList.get(numsList.size()-k);
    }
}
