class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, 0, new ArrayList<>());
        return result;
    }
    void backtrack(List<List<Integer>> result, int[] nums, int target, int ind, List<Integer> temp) {
        if (target < 0)
            return;
        else if (target == 0)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = ind; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(result, nums, target - nums[i], i, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}