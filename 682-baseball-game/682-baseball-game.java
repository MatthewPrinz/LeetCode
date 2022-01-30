class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> parsedOps = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                parsedOps.pop();
            } else if (ops[i].equals("D")) {
                int value = parsedOps.peek();
                parsedOps.push(value * 2);
            } else if (ops[i].equals("+")) {
                int operand1 = parsedOps.pop();
                int operand2 = parsedOps.pop();
                parsedOps.push(operand2);
                parsedOps.push(operand1);               
                parsedOps.push(operand1 + operand2);
            } else {
                parsedOps.push(Integer.parseInt(ops[i]));
            }
        }
        int result = 0;
        while (!parsedOps.isEmpty()) {
            result += parsedOps.pop();
        }
        return result;
    }
}