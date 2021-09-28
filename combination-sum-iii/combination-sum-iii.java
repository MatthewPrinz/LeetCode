class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, k, n, new ArrayList<>(), 1);
        return result;
    }
    
    void backtrack(List<List<Integer>> result, int n, int target, List<Integer> temp, int start) {
        if (target < 0 || n < 0)
            return;
        else if (target == 0 && n == 0)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                backtrack(result, n-1, target - i, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}