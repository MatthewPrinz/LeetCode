class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder finalProduct = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        if ((num1.equals("0") || num2.equals("0"))) {
            return "0";
        }
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[i + j + 1]; // we've subtracted in the loop, so to get the carry, we need to add 1

                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }
        for (int k : result) {
            sb.append(k);
        }
        boolean flag = true; // flag == true if we're removing leading zeroes
        for (int i = 0; i < sb.toString().length(); i++) {
            if (sb.toString().charAt(i) == '0' && flag) {
                continue;
            } else {
                flag = false;
                finalProduct.append(sb.toString().charAt(i));
            }
        }
        return finalProduct.toString();
    }
}