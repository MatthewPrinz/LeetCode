class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        return helper((double)n);
    }
    
    public boolean helper(double n)
    {
        if (n == 2.0)
            return true;
        else if (n < 2.0)
            return false;
        else 
            return helper(n/(double)2.0);
    }
}