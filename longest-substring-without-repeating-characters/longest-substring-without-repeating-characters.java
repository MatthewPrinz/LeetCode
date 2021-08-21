class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) || set.contains(s.charAt(j))) {
                    break;
                }
                else { 
                    set.add(s.charAt(j));
                }
                // System.out.printf("set is: %s\n", set);
            }
            set.add(s.charAt(i));
            if (set.size() > max)
                max = set.size();
            set.clear();
        }
        return max;
    }
}