class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        StringBuilder finalProduct = new StringBuilder();
        
        if (((num1.charAt(0) - '0') == 0) || ((num2.charAt(0) - '0') == 0)) {
            return "0";
        }
        
        int[] helper = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) -'0') * (num2.charAt(j) -'0');
                product += helper[i + j + 1];
                
                helper[i + j] += product / 10;
                helper[i + j + 1] = product % 10;
            }
        }
        for (int k : helper) {
            if (k == 0 && finalProduct.length() == 0) {
                continue;
            }
            finalProduct.append(k);
        }
        return finalProduct.toString();
    }
}