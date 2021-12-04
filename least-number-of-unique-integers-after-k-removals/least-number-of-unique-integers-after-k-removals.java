class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> valueToFrequency = new HashMap<>();
        for (int i : arr) {
            valueToFrequency.put(i, valueToFrequency.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> uniques = new ArrayList<>(valueToFrequency.entrySet());
        uniques.sort(Map.Entry.comparingByValue());
        int result = uniques.size();
        int removed = 0;
        int newK = k;
        for (Map.Entry<Integer, Integer> me : uniques) {
            if (me.getValue() - newK <= 0) {
                removed++;
                newK -= me.getValue();
            }
        }
        return result - removed;
    }
}