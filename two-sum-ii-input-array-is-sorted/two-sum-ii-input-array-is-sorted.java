class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!numToIndex.containsKey(numbers[i])) {
                numToIndex.put(numbers[i], i);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int addend = numToIndex.getOrDefault(target - numbers[i], -1);
            if (addend != -1) {
                int[] result = new int[2];
                if (addend < i) {
                    result[0] = ++addend;
                    result[1] = ++i;
                } else {
                    result[0] = ++i;
                    result[1] = ++addend;
                }
                return result;
            }
        }
        return new int[]{0, 0};
    }
}