class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> rowToNumSoldiers = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int numSoldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    numSoldiers++;
                }
                rowToNumSoldiers.put(i, numSoldiers);
            }
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> one, Map.Entry<Integer,Integer> two) {
                if (one.getValue() < two.getValue()) {
                    return -1;
                } else if (one.getValue() == two.getValue()) {
                    return one.getKey().compareTo(two.getKey());
                } else {
                    return 1;
                }
            }
        };
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : rowToNumSoldiers.entrySet()) {
            pq.add(entry);
        }
    for (int i = 0; i < k; i++) {
        result[i] = pq.poll().getKey();
    }
    return result;
}
}