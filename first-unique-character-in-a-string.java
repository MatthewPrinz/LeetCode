class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                int prev = map.get(s.charAt(i));
                map.put(s.charAt(i), prev+1);
            }
            else
            {
                map.put(s.charAt(i), 1);
            }
        }
        int minPos = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> me : map.entrySet())
        {
            if (me.getValue() < 2)
            {
                if (s.indexOf(me.getKey()) < minPos)
                    minPos = s.indexOf(me.getKey());
            }
        }
        if (minPos < Integer.MAX_VALUE)
            return minPos;
        return -1;
    }
}
