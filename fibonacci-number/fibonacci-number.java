class Solution {
    public int fib(int n) {
        int result = 0;
        int fnm1 = 1;
        int fnm2 = 0;
        if (n == 0)
            return fnm2;
        else if (n == 1)
            return fnm1;
        for (int i = 2; i <= n; i++) {
            result = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = result;
        }
        return result;
    }
}