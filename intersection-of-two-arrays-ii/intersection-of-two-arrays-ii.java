class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
        {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++)
        {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        System.out.println(map1);
        System.out.println(map2);
        for (Map.Entry<Integer, Integer> me : map1.entrySet())
        {
            if (map2.keySet().contains(me.getKey()))
            {
                int less;
                if (me.getValue() < map2.get(me.getKey()))
                    less = me.getValue();
                else
                    less = map2.get(me.getKey());
                System.out.println(less);
                System.out.println(me.getValue());
                System.out.println(map2.get(me.getKey()));
                for (int i = 0; i < less; i++)
                {
                    result.add(me.getKey());
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
