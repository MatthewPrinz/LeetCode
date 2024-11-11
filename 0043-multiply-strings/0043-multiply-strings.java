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
                // 1. this is adding the carry over. we look at index i + j + 1 because the carry over from the last 
                // iteration of the loop was in that iteration's i + j. Since we have subtracted 1 from j in the for loop,
                // we must add 1 to i + j to retrieve that carry over.
                product += helper[i + j + 1]; 
                
                // 2. This is where we put carry over
                helper[i + j] += product / 10;
                
                // 3. when we added the carry over in (1), we added it to the product. so we've been accumulating the 
                // the numbers we get from (2) so we can set this index (as the number that is stored has already been added).
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