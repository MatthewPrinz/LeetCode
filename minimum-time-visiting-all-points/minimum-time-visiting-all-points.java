class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        if (points == null || points.length == 1 || points[0].length == 0)
            return distance;
        for (int i = 0; i < points.length - 1; i++) {
            distance += Math.max(Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
        }
        return distance;
    }
}