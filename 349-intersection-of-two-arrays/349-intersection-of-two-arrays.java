class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> nums1Unique = new HashSet<>();
        for (int n : nums1) {
            nums1Unique.add(n);
        }
        for (int n : nums2) {
            if (nums1Unique.contains(n)) {
                intersection.add(n);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int n : intersection) {
            result[i++] = n;
        }
        return result;
    }
}