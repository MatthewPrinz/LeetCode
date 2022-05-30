class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.isEmpty()) {
            return max;
        }
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charToLastIndex.containsKey(s.charAt(i))) {
                j = Math.max(charToLastIndex.get(s.charAt(i)) + 1, j);
            }
            charToLastIndex.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1); 
        }
        return max;
    }
}