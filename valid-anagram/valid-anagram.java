class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> ana1 = new HashMap<>();
        Map<Character, Integer> ana2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            ana1.put(s.charAt(i), ana1.getOrDefault(s.charAt(i), 0) + 1);
            ana2.put(t.charAt(i), ana2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : ana1.entrySet()) {
            if (ana2.containsKey(entry.getKey())) {
                if (ana2.get(entry.getKey()).intValue() != (entry.getValue()).intValue()) 
                    return false;
            } else 
                return false;
        }
        return true;
    }
}