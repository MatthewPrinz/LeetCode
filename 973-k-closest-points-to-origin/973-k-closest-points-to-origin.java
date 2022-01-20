class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Map<int[], Double> pointToDistance = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointToDistance.put(points[i], Math.sqrt(Math.pow((points[i][0]), 2) + Math.pow((points[i][1]), 2)));
        }
        Queue<Map.Entry<int[], Double>> queue = new PriorityQueue<>(pointToDistance.size(), Map.Entry.comparingByValue());
        queue.addAll(pointToDistance.entrySet());
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove().getKey();
        }
        return result;
    }
}