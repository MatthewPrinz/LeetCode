class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                map.put(nums[i], (map.get(nums[i])+1));
            }
            else
            {
                map.put(nums[i], 1);
            }
        }
        int n = nums.length/2;
        for (Map.Entry<Integer, Integer> e : map.entrySet())
        {
            if (e.getValue() > n )
                return e.getKey();
        }
        return 0;
    }
}
