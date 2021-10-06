class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0;
                while (lo < hi) {
                    sum = nums[i] + nums[lo] + nums[hi];
                    if (sum == 0) {
                        result.add(List.of(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if (sum < 0)
                        lo++;
                    else 
                        hi--;
                }
            }
        }
        return result;
    }
}