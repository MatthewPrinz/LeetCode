class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(numToFreq.size(), (o1, o2) -> {
            return -1 * o1.getValue().compareTo(o2.getValue());
        });
        queue.addAll(numToFreq.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove().getKey();
        }
        return result;
    }
}