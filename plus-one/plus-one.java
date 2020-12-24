class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
​
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
        // List<Integer> list = new ArrayList<>();
        // boolean carry = false;
        // for (int i = digits.length - 1; i >= 0; i--)
        // {
        //     if (i == digits.length - 1)
        //     {
        //         digits[i]++;
        //     }
        //     if (carry)
        //     {
        //         digits[i]++;
        //         carry = false;
        //     }
        //     if (digits[i] >= 10)
        //     {
        //         digits[i] -= 10;
        //         list.add(digits[i]);
        //         carry = true;
        //     }
        //     else
        //     {
        //         list.add(digits[i]);
        //     }
        // }
        // if (carry)
        // {
        //     list.add(1);
        // }
        // Collections.reverse(list);
        // return list.stream().mapToInt(i->i).toArray();
    }
}
