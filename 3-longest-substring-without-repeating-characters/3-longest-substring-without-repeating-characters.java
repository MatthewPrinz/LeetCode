class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charToLastIndex.containsKey(s.charAt(i))) {
                j = Math.max(j, charToLastIndex.get(s.charAt(i)) + 1);
            }
            charToLastIndex.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}