class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<Integer>());
        return result;
    }
    void backtrack(List<List<Integer>> result, int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            backtrack(result, nums, temp);
            temp.remove(temp.size()-1);
            
        }
    }
}