class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, n, k, new ArrayList<Integer>(), 1);
        return result;
    }
    void backtrack(List<List<Integer>> result, int n, int k, List<Integer> range, int start) {
        if (k == 0)
            result.add(new ArrayList<>(range));
        else {
            for (int i = start; i <= n; i++) {
                range.add(i);
                backtrack(result, n, k-1, range, i+1);
                range.remove(range.size()-1);
            }
        }
    }
}