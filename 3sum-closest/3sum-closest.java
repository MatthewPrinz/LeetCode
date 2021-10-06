class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = (nums[0] + nums[1] + nums[2]);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int low = i+1;
                int high = nums.length - 1;
                int sum = -1;
                while (low < high) {
                    sum = nums[i] + nums[low] + nums[high];
                    if (sum > target)
                        high--;
                    else 
                        low++;
                    if (Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                }
            }
        }
        return result;
    }
}