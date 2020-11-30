class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++)
        {
            if (sMap.containsKey(s.charAt(i)))
            {
                int prev = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), prev+1);
            }
            if (tMap.containsKey(t.charAt(i)))
            {
                int prev = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), prev+1);
            }
            if (!sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i), 1);
            if (!tMap.containsKey(t.charAt(i)))
                tMap.put(t.charAt(i), 1);
        }
        for (Map.Entry me : sMap.entrySet())
        {
            if (tMap.containsKey(me.getKey()))
            {
                if (!(tMap.get(me.getKey())).equals((me.getValue())))
                {
                    System.out.println("Key: " + me.getKey() + " tMap Val = " + tMap.get(me.getKey()) + " sMap Val = " + me.getValue()); 
                    return false;
                }
            }
            else 
                return false;
        }
        return true;
    }
}
