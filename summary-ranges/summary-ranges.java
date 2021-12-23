class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int beginRange = 0;
        boolean beginSet = false;
        for (int i = 0; i < nums.length; i++) {
            if (((i + 1) < nums.length) && nums[i + 1] == (nums[i] + 1)) {
                if (!beginSet) {
                    beginRange = nums[i];
                    beginSet = true;
                }
            } else {
                if (beginSet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(beginRange).append("->").append(nums[i]);
                    beginSet = false;
                    result.add(sb.toString());
                } else {
                    result.add(Integer.toString(nums[i]));
                }
            }
        }
        return result;
    }
}