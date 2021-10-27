class Solution {
    
    public static final String[] KEYS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        backtrack(result, digits, "", 0);
        return result;
    }
    void backtrack(List<String> result, String digits, String temp, int offset) {
        if (digits.length() == temp.length())
            result.add(temp);
        else {
            String mapping = KEYS[(digits.charAt(offset) - '2')];
            for (int i = 0; i < mapping.length(); i++) {
                backtrack(result, digits, temp + mapping.charAt(i), offset + 1);
            }
        }
    }
}