class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else
        {
            String num = Integer.toString(x);
            for (int i = 0; i < num.length() / 2; i++)
            {
                if (num.charAt(i) != num.charAt(num.length()-i-1))
                    return false;
            }
        }
        return true;
    }
}