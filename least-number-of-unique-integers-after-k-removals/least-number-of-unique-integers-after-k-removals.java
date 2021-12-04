class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> valueToFrequency = new HashMap<>();
        for (int i : arr) {
            valueToFrequency.put(i, valueToFrequency.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> uniques = new PriorityQueue<>(valueToFrequency.values());
        int result = uniques.size();
        int removed = 0;
        int newK = k;
        while (!uniques.isEmpty()) {
            int frequency = uniques.poll();
            if (frequency - newK <= 0) {
                removed++;
                newK -= frequency;
            }
        }
        return result - removed;
    }
}