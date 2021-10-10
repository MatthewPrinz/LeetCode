class Solution {
    public int tribonacci(int n) {
        int[] memos = new int[n+1];
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        memos[0] = 0;
        memos[1] = 1;
        memos[2] = 1;
        for (int i = 3; i <= n; i++) {
            memos[i] = memos[i-3] + memos[i-2] + memos[i-1];
        }
        return memos[n];
    }
}