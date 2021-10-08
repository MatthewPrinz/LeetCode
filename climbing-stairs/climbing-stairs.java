class Solution {
    public int climbStairs(int n) {
        int[] numSteps = new int[n + 1];
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        numSteps[0] = 0;
        numSteps[1] = 1;
        numSteps[2] = 2;
        for (int i = 3; i <= n; i++) {
            numSteps[i] = numSteps[i-2] + numSteps[i-1];
        }
        return numSteps[n];
    }
}