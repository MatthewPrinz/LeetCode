class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i), 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(charToFreq.size(), (o1, o2) -> {
            return -1 * o1.getValue().compareTo(o2.getValue());
        });
        heap.addAll(charToFreq.entrySet());
        StringBuilder sb = new StringBuilder();
        while (heap.size() > 1) {
            Map.Entry<Character, Integer> current = heap.remove();
            Map.Entry<Character, Integer> next = heap.remove();
            sb.append(current.getKey());
            sb.append(next.getKey());
            current.setValue(current.getValue() - 1);
            next.setValue(next.getValue() - 1);
            if (current.getValue() > 0) {
                heap.add(current);
            }
            if (next.getValue() > 0) {
                heap.add(next);
            }

        }
        if (!heap.isEmpty()) {
            Map.Entry<Character, Integer> last = heap.remove();
            if (last.getValue() > 1) {
                return "";
            }
            sb.append(last.getKey());
        }
        return sb.toString();
    }
}