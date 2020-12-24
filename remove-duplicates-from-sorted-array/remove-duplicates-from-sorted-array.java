class Solution {
    public int removeDuplicates(int[] nums) {
        
        // O(NlogN) time, O(N) memory
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
        {
            set.add(n);
        }
        int i = 0;
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer n : list)
        {
            nums[i] = n;
            i++;
        }
        for (; i < nums.length; i++)
            nums[i] = 0;
        return set.size();
    }
}
