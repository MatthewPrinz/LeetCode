class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    void backtrack(List<List<Integer>> result, int[] nums, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}