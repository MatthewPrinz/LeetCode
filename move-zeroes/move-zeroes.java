class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i : nums) {
            if (i != 0)
                nums[insertPos++] = i;
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}