class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        lefts[0] = 1;
        rights[rights.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = lefts[i - 1] * nums[i - 1];
        }
        for (int i = rights.length - 2; i >= 0; i--) {
            rights[i] = rights[i + 1] * nums[i + 1];
        }
        int[] products = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            products[i] = lefts[i] * rights[i];
        }
        return products;
    }
}