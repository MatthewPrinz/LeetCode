class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return -1 * o1.compareTo(o2);
            });
        for (int n : nums) {
            if (!set.contains(n)) {
                queue.add(n);
                set.add(n);
            }
        }
        if (queue.size() < 3) {
            return queue.poll();
        } else {
            int result = -1;
            for (int i = 0; i < 3; i++) {
                result = queue.poll();
            }
            return result;
        }
    }
}