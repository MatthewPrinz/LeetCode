class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        int j = 1;
        while (i < s.length())
        {
            try {
                if (s.charAt(i) == 'I')
                {↔}
                if (s.charAt(i) == 'X')
                {↔}
                if (s.charAt(i) == 'C')
                {↔}
            }
            catch (Exception e)
            {
            }
            if (s.charAt(i) == 'I')
                result += 1;
            if (s.charAt(i) == 'V')
                result += 5;
            if (s.charAt(i) == 'X')
                result += 10;
            if (s.charAt(i) == 'L')
                result += 50;
            if (s.charAt(i) == 'C')
                result += 100;
            if (s.charAt(i) == 'D')
                result += 500;
            if (s.charAt(i) == 'M')
                result += 1000;
            i++; 
            j++;
        }
        return result;
    }
}
