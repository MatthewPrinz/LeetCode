import java.util.*;
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length() || s.length() == 0 || goal.length() == 0)
            return false;

        int n = s.length();
        List<Integer> indices = indicesOf(s, goal.charAt(0));
        for (int ind : indices) {
            int j = 0;
            boolean flag = true;
            for (int i = ind; i < n; i++) {
                if (s.charAt(i) != goal.charAt(j)) {
                    flag = false;
                }
                j++;
            }
            for (int i = 0; i < ind; i++) {
                if (s.charAt(i) != goal.charAt((i + j) % s.length()))
                    flag = false;
            }
            if (flag == true)
                return true;
        }
        return false;
    }
    
        public static List<Integer> indicesOf(String s, char c) {
        List<Integer> result = new ArrayList<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] == c)
                result.add(i);
        }
        return result;
    }
}