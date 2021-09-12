class Solution {
    public boolean isPowerOfFour(int n) {
        return helper((double)n);
    }
    public boolean helper(double n) {
        if (n == 1.0)
            return true;
        else if (n < 1.0)
            return false;
        else return helper(n/4.0);
    }
}