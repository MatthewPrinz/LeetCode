class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length())
            return addBinary(b, a);
        int i = a.length() - 1, j = b.length() - 1;
        boolean carry = false;
        StringBuilder result = new StringBuilder();
        while (i >= 0) {
            int digit = (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0) + (carry ? 1 : 0);
            carry = false;
            if (digit >= 2) {
                digit -= 2;
                carry = true;
            }
            result.insert(0, digit);
        }
        if (carry) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}