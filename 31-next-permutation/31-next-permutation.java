class Solution {
/* See: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm */
    
    public void nextPermutation(int[] nums) {
        boolean descending = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                descending = false;
            }
        }
        if (descending) {
            Arrays.sort(nums);
        } else {
            // i: beginning of the suffix
            // gtPivotIndex: index of the smallest element in the suffix that is greater than the pivot
            int begin = 0, pivot = -1, gtPivotIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    begin = i;
                    break;
                }
            }
            pivot = nums[begin - 1];
            gtPivotIndex = begin;
            for (int i = begin; i < nums.length; i++) {
                if (nums[i] <= nums[gtPivotIndex] && nums[i] > pivot) {
                    gtPivotIndex = i;
                }
            }
            int temp = nums[gtPivotIndex];
            nums[gtPivotIndex] = nums[begin - 1];
            nums[begin - 1] = temp;
            int end = nums.length - 1;
            while (begin < end) {
                temp = nums[begin];
                nums[begin++] = nums[end];
                nums[end--] = temp;
            }
        }
    }
}