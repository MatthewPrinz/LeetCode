class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;
    }
    void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            backtrack(result, nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}