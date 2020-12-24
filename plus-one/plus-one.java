class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--)
        {
            if (i == digits.length - 1)
            {
                digits[i]++;
            }
            if (carry)
            {
                digits[i]++;
                carry = false;
            }
            if (digits[i] >= 10)
            {
                digits[i] -= 10;
                list.add(digits[i]);
                carry = true;
            }
            else
            {
                list.add(digits[i]);
            }
        }
        if (carry)
        {
            list.add(1);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}
