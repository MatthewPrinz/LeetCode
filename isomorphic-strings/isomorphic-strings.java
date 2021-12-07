class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapping.containsKey(s.charAt(i))) {
                if (mapping.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            mapping.put(s.charAt(i), t.charAt(i));
        }
        Set<Character> set = new HashSet<>();
        for (char c : mapping.values()) {
            if (set.contains(c))
                return false;
            set.add(c);
        }
        return true;
    }
}