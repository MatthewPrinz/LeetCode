class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Map<int[], Double> pointToDistance = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointToDistance.put(points[i], Math.sqrt(Math.pow((points[i][0]), 2) + Math.pow((points[i][1]), 2)));
        }
        List<Map.Entry<int[], Double>> distances = new ArrayList<>(pointToDistance.entrySet());
        distances.sort(Map.Entry.comparingByValue());
        for (int i = 1; i <= k; i++) {
            result[i - 1] = distances.get(i - 1).getKey();
        }
        return result;
    }
}