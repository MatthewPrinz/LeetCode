class Solution {
    public String longestCommonPrefix(String[] strs) {
        /* Time Complexity: 
        length of strs is n
        smallest string length is m
        O(Max(nlogn, m))
        */
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return i == 0 ? "" : last.substring(0, i);
    }
}