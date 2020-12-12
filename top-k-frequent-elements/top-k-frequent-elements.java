class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
        {
            if (map.containsKey(n))
            {
                int prev = map.get(n);
                map.put(n, prev+1);
            }
            else
            {
                map.put(n, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<>(map.entrySet());
        listMap.sort(Map.Entry.comparingByValue());
        for (int i = 1; i <= k; i++)
        {
            result[i-1] = listMap.get(listMap.size()-i).getKey(); 
        }
        return result;
    }
}
