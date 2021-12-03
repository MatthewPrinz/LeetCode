class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToLastIndex.put(s.charAt(i), i);
        }
        int i = 0;
        while (i < s.length()) {
            int last = charToLastIndex.get(s.charAt(i));
            for (int j = i + 1; j < last; j++) {
                last = Math.max(last, charToLastIndex.get(s.charAt(j)));
            }
            result.add(last - i + 1);
            i = last + 1;
        }
        return result;
    }
}