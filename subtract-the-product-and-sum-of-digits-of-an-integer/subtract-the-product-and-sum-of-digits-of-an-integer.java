class Solution {
    public int subtractProductAndSum(int n) {
        int prod = n % 10;
        int sum = n % 10;
        n /= 10;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            prod *= digit;
            sum += digit;
        }
        return prod - sum;
    }
}