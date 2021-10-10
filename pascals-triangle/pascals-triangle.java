class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i >= 2) {
                for (int j = 0; j < (i - 1); j++) {
                    List<Integer> above = triangle.get(i-1);
                    row.add(above.get(j) + above.get(j+1)); 
                }
            }
            if (i >= 1)
                row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}