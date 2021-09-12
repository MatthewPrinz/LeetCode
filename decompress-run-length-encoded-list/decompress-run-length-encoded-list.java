class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i+=2) {
            int freq = nums[i];
            int val = nums[i+1];
            for (int j = 0; j < freq; j++)
                resultList.add(val);
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}