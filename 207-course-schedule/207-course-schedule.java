class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            List<Integer> l = adjacencyList.getOrDefault(pre[1], new ArrayList<>());
            l.add(pre[0]);
            indegrees[pre[0]]++;
            adjacencyList.put(pre[1], l);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (indegrees[cur] == 0) {
                count++;
            } 
            if (!adjacencyList.containsKey(cur)) {
                continue;
            }
            for (int edge : adjacencyList.get(cur)) {
                indegrees[edge]--;
                if (indegrees[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        return count == numCourses;
    }
}