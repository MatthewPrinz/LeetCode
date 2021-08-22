class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int numKilled = 0;
        double[] arrivals = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrivals[i] = (double)(dist[i]) / speed[i];
        }
        Arrays.sort(arrivals);
        double currentTime = 0;
        for (int i = 0; i < arrivals.length; i++) {
            if (arrivals[i] > currentTime)
                numKilled++;
            else
                break;
            currentTime += 1.0;
        }
        return numKilled;
    }
}