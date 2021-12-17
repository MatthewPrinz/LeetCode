class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length())
            return addBinary(b, a);
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false;
        StringBuilder result = new StringBuilder();
        while (i >= 0) {
            int part1 = a.charAt(i) == '1' ? 1 : 0;
            int part2;
            if (j >= 0) {
                part2 = b.charAt(j) == '1' ? 1 : 0;
            } else {
                part2 = 0;
            }
            int digit = part1 + part2 + (carry ? 1 : 0);
            carry = false;
            if (digit >= 2) {
                digit -= 2;
                carry = true;
            }
            result.insert(0, digit);
            i--;
            j--;
        }
        if (carry) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}