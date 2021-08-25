class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charToFrequency = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            charToFrequency.put(c, charToFrequency.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> listMap = new ArrayList<>(charToFrequency.entrySet());
        listMap.sort(Map.Entry.comparingByValue());
        Collections.reverse(listMap);
        for (Map.Entry<Character, Integer> me : listMap) {
            for (int i = 0; i < me.getValue(); i++) {
                result.append(me.getKey());
            }
        }
        return result.toString();
     }
}