class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result ^= nums[i];
        }
        return result;
        
        // HashMap Solution
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++){
        //     if (map.containsKey(nums[i]))
        //         map.put(nums[i], (map.get(nums[i]))+1);
        //     else
        //         map.put(nums[i], 1);
        // }
        // for (Map.Entry<Integer, Integer> me : map.entrySet())
        // {
        //     if (me.getValue() == 1)
        //         return me.getKey();
        // }
        // return 0;
    }
}
