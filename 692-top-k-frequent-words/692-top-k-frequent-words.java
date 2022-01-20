class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsToFrequency = new HashMap<>();
        for (String word : words) {
            wordsToFrequency.put(word, wordsToFrequency.getOrDefault(word, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(wordsToFrequency.size(), (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() == o2.getValue()) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return 1;
            }
        });
        queue.addAll(wordsToFrequency.entrySet());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.remove().getKey());
        }
        return result;
                                                                
    }
}