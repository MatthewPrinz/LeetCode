class Solution {
    public int maxLength(List<String> arr) {
        List<String> results = new ArrayList<>();
        backtrack(results, arr, "", 0);
        int max = 0;
        for (String s : results) {
            if (s.length() > max)
                max = s.length();
        }
        return max;
    }
    void backtrack(List<String> results, List<String> arr, String build, int start) {
        results.add(build);
        for (int i = start; i < arr.size(); i++) {
            if (isUnique(build, arr.get(i))) {
                build += arr.get(i);
                backtrack(results, arr, build, i+1);
                build = build.substring(0, build.length()-arr.get(i).length());
            }
        }
    }
    
    boolean isUnique(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i)))
                return false;
            set.add(s1.charAt(i));
        }
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            if (st.contains(s2.charAt(i)))
                return false;
            st.add(s2.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i)))
                return false;
        }
        return true;
    }
}