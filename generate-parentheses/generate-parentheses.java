class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, 0, 0);
        return result;
    }
    
    void backtrack(List<String> result, String s, int n, int open, int close) {
        if (s.length() == n * 2)
            result.add(s);
        if (open < n) {
            backtrack(result, s + "(", n, open + 1, close);
        }
        if (close < open) {
            backtrack(result, s + ")", n, open, close + 1);
        }
    }
}