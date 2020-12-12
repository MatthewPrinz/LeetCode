class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = -1;
        int lastPos = -1;
        for (int i = 0; i < nums.length; i++)   
        {
            if (nums[i] == target && firstPos == -1)
            {
                firstPos = i;
                lastPos = i;
            }
            else if (nums[i] == target && firstPos != -1)
            {
                lastPos = i;
            }
        }
        return new int[] {firstPos, lastPos};
    }
}
