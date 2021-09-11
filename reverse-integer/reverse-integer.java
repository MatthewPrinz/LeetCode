class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int input = x;
        if (x < 0)
        {
            negative = true;
            x *= -1;
        }
        String intx = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intx.length(); i++)
        {
            sb.append(intx.charAt(intx.length()-i-1));            
        }
        Integer result = 0;
        try {
         result = Integer.parseInt(sb.toString());
            }
        catch (Exception e)
        {
            return 0;
        }
        if (negative)
            result *= -1;
        return result;
    }
}