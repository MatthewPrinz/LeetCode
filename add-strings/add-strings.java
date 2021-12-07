class Solution {
    public String addStrings(String num1, String num2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < num1.length(); i++) {
            stack1.push(num1.charAt(i) - 0x30);
        }
        for (int i = 0; i < num2.length(); i++) {
            stack2.push(num2.charAt(i) - 0x30);
        }
        if (num1.length() < num2.length())
            return addStrings(num2, num1);
        StringBuilder result = new StringBuilder();
        boolean carry = false;
        while (!stack1.isEmpty()) {
            int part1 = stack1.pop();
            int part2 = stack2.isEmpty() ? 0 : stack2.pop();
            int digit = part1 + part2 + (carry ? 1 : 0);
            carry = false;
            if (digit >= 10) {
                carry = true;
                digit -= 10;
            }
            result.insert(0, digit);
        }
        if (carry)
            result.insert(0, 1);
        return result.toString();
    }
}