class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> colorToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            colorToCount.put(nums[i], colorToCount.getOrDefault(nums[i], 0) + 1);
        }
        int numZeroes, numOnes, numTwos;
        numZeroes = numOnes = numTwos = 0;
        if (colorToCount.containsKey(0))
            numZeroes = colorToCount.get(0);
        if (colorToCount.containsKey(1))
            numOnes = colorToCount.get(1);
        if (colorToCount.containsKey(2))
            numTwos = colorToCount.get(2);
        int i = 0;
        while ((numZeroes > 0 || numOnes > 0 || numTwos > 0) && i < nums.length) {
            if (numZeroes > 0) {
                nums[i] = 0;
                numZeroes--;
            } else if (numOnes > 0) {
                nums[i] = 1;
                numOnes--;
            } else {
                nums[i] = 2;
            }
            i++;
        }
    }
}