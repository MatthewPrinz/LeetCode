class Solution {
    public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (nums.length == 0)
    //         return result;
    //     Arrays.sort(nums);
    //     [-1, -1, 0, 1]
    //     for (int i = 0; i < nums.length - 2; i++) {
    //         if (i == 0 || nums[i] != nums[i-1]) {
    //             int lo = i + 1;
    //             int hi = nums.length - 1;
    //             int sum = 0;
    //             while (lo < hi) {
    //                 sum = nums[i] + nums[lo] + nums[hi];
    //                 if (sum == 0) {
    //                     result.add(List.of(nums[i], nums[lo], nums[hi]));
    //                     while (lo < hi && nums[lo] == nums[lo+1]) lo++;
    //                     while (lo < hi && nums[hi] == nums[hi-1]) hi--;
    //                     lo++;
    //                     hi--;
    //                 }
    //                 else if (sum < 0)
    //                     hi--;
    //                 else 
    //                     lo++;
    //             }
    //         }
    //     }
    //     return result;
    // }
}