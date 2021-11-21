class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, cumulative = 0;
        Map<Integer, Integer> valueToFrequency = new HashMap<>();
        valueToFrequency.put(0, 1);
        for (int n : nums) {
            cumulative += n;
            if (valueToFrequency.containsKey(cumulative - k)) {
                result += valueToFrequency.get(cumulative - k);
            }
            valueToFrequency.put(cumulative, valueToFrequency.getOrDefault(cumulative, 0) + 1);
        }
        return result;
    }
}