class Solution {
    public static final String[] KEYS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        backtrack(result, "", 0, digits);
        return result;
    }
    void backtrack(List<String> result, String temp, int offset, String digits) {
        if (temp.length() == digits.length()) 
            result.add(temp);
        else {
            String letters = KEYS[(digits.charAt(offset) - '2')];
            for (int i = 0; i < letters.length(); i++) {
                backtrack(result, temp + letters.charAt(i), offset+1, digits);
            }  
        }
    }
}