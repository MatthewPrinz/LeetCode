class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            List<Integer> l = adjacencyList.getOrDefault(pre[1], new ArrayList<>());
            l.add(pre[0]);
            indegree[pre[0]]++;
            adjacencyList.put(pre[1], l);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        boolean changeMade = false;
        int index = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (indegree[i] == 0) {
                result[index++] = i;
                changeMade = true;
            }
            if (!adjacencyList.containsKey(i)) {
                continue;
            }
            for (int edge : adjacencyList.get(i)) {
                indegree[edge]--;
                if (indegree[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        return index == numCourses ? result : new int[]{};
    }
}