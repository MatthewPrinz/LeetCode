class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int n : nums) {
            numToFrequency.put(n, numToFrequency.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<>(numToFrequency.entrySet());
        listMap.sort(Map.Entry.comparingByValue());
        for (int i = 1; i <= k; i++) {
            result[i-1] = listMap.get(listMap.size()-i).getKey(); 
        }
        return result;
    }
}