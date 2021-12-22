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
            // gtPivot: smallest element in the suffix that is greater than the pivot
            int begin = 0, pivot = -1, gtPivot = -1, gtPivotIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    begin = i;
                    pivot = nums[i - 1];
                    gtPivot = nums[i];
                    gtPivotIndex = i;
                    break;
                }
            }

            for (int i = begin; i < nums.length; i++) {
                if (nums[i] <= gtPivot && nums[i] > pivot) {
                    gtPivot = nums[i];
                    gtPivotIndex = i;
                }
            }
            int temp = gtPivot;
            nums[gtPivotIndex] = nums[begin - 1];
            nums[begin - 1] = gtPivot;
            int swapIndex = nums.length - 1;
            for (int i = begin; i < (begin + ((nums.length - begin) / 2)); i++) {
                temp = nums[swapIndex];
                nums[swapIndex] = nums[i];
                nums[i] = temp;
                swapIndex--;
            }
        }
    }
}