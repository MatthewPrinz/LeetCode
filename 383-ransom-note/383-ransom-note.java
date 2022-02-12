class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charToFrequency = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            charToFrequency.put(magazine.charAt(i), charToFrequency.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (charToFrequency.containsKey(ransomNote.charAt(i)) && charToFrequency.get(ransomNote.charAt(i)) > 0) {
                charToFrequency.put(ransomNote.charAt(i), charToFrequency.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}