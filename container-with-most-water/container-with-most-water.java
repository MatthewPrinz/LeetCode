class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = -1;
        while (low < high) {
            max = Math.max(max, (Math.min(height[low], height[high]) * (high - low)));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}