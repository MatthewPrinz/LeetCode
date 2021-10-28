class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, n, k, new ArrayList<>(), 1);
        return result;
    }
    void backtrack(List<List<Integer>> result, int n, int k, List<Integer> temp, int start) {
        if (temp.size() == k) 
            result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i <= n; i++) {
                temp.add(i);
                backtrack(result, n, k, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}