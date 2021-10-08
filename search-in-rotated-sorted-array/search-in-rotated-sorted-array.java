class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) 
                low = mid + 1;
            else 
                high = mid;
        }
        int rot = low;
        low = 0;
        high = nums.length - 1;
        // The usual binary search and accounting for rotation.
        while (low <= high) {
            int mid = (low + high) / 2;
            int realmid = (mid + rot) % nums.length;
            if (nums[realmid] == target)
                return realmid;
            if (nums[realmid] < target)
                low = mid + 1;
            else 
                high = mid-1;
        }
        return -1;
    }
}