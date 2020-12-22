public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        boolean negative = false;
        if (n < 0)
        {
            n = ~n;
            negative = true;
        }
        while (n != 0)
        {
            System.out.println("n is: " + n);
            result += (1&n);
            n >>= 1;
            System.out.println("n rsh 1 is: " + n);
        }
        result = negative ? 32 - result : result;
        return result;
    }
}
