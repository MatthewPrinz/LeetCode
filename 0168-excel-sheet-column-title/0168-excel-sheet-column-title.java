class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int offset = (int)'A'; 
        while (columnNumber > 0) {
            columnNumber -= 1;
            char letter = (char)((columnNumber % 26) + offset);
            columnNumber /= 26;
            result.insert(0, letter);
        }
        return result.toString();
    }
}