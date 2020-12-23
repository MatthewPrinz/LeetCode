class Solution {
    public int[] countBits(int num) {
        // non DP solution
        // int[] result = new int[num+1];
        // for (int i = 0; i <= num; i++)
        // {
        //     int countBits = i;
        //     int count = 0;
        //     while (countBits != 0)
        //     {
        //         count += (1&countBits);
        //         countBits >>= 1;
        //     }
        //     result[i] = count;
        // }
        // return result;
        
        // DP solution
        int[] result = new int[num+1];
        // looking a lot at this:
        // https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution. reproduced at bottom of problem
        // i'm thinking that once we "clear" a power of 2 (e.g. 3, 5, 9, 17), we increase offset by another *2
        // so we just need to find when we clear a power of 2
        result[0] = 0;
        int currentOffset = 1; // represents 2^0
        for (int i = 1; i <= num; i++)
        {
            if (currentOffset * 2 == i)
                currentOffset *= 2;
            result[i] = result[i-currentOffset] + 1;
        }
        return result;
    }
}
        /*
        Question:
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
​
Thinking:
​
We do not need check the input parameter, because the question has already mentioned that the number is non negative.
​
How we do this? The first idea come up with is find the pattern or rules for the result. Therefore, we can get following pattern
​
Index : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
​
num : 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4
​
Do you find the pattern?
​
Obviously, this is overlap sub problem, and we can come up the DP solution. For now, we need find the function to implement DP.
​
dp[0] = 0;
​
dp[1] = dp[0] + 1;
​
