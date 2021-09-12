class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += findDigits(nums[i]);
        }
        return result;
    }
    
    int findDigits(int n) {
        int digits = 0;
        while (n > 0) {
            n /= 10;
            digits++;
        }
        return digits % 2 == 0 ? 1 : 0;
    }
}