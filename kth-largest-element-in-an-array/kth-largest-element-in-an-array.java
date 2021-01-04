class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(nums.length);
        int result = 0; 
        for (int n : nums)
        {
            queue.add(n);
        }
        int index = queue.size() - k;
        for (int i = 0; i <= index; i++)
        {
            if (i != index)
            {
                queue.remove();
                continue;
            }
            else
            {
                result = queue.peek();
            }
        }
        return result;
    }
}
