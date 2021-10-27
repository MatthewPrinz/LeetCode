class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, "", 0, 0);
        return result;
    }
    
    void backtrack(List<String> result, int n, String temp, int open, int close) {
        if (temp.length() == n*2) {
            result.add(temp);
        }
        if (open < n) {
            backtrack(result, n, temp + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(result, n, temp + ")", open, close + 1);
        }
    }
}