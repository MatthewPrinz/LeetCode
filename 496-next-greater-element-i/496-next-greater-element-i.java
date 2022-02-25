class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreatestToEle = new HashMap<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                nextGreatestToEle.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreatestToEle.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}