class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    
    void backtrack(List<List<Integer>> result, int[] nums, List<Integer> temp, boolean[] used) {
        if (nums.length == temp.size())
            result.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) 
                continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(result, nums, temp, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}