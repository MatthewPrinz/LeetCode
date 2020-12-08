class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true)
        {
            List<Integer> digits = getDigits(n);
            for (Integer ele : digits)
            {
                System.out.println(ele);
            }
            int sum = 0;
            for (Integer ele : digits)
            {
                sum += ele * ele;
            }
            if (set.contains(sum))
                return false;
            else if (sum == 1)
                return true;
            set.add(sum);
            n = sum;
        }
    }
    public List<Integer> getDigits(int n)
    {
        List<Integer> result = new ArrayList<>();
        if (n == 0)
        {
            result.add(0);
            return result;
        }
        if (n == 1)
        {
            result.add(1);
            return result;
        }
        while (n >= 1)
        {
            int digit = n % 10;
            result.add(digit);
            n /= 10;
        }
        return result;
    }
    
}
