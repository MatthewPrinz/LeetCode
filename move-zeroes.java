class Solution {
    public void moveZeroes(int[] nums) {
        
        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) 
                nums[insertPos++] = num;
        }        
​
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        // ArrayList<Integer> numsIneqZero = new ArrayList<>();
        // int zCount = 0;
        // for (int i = 0; i < nums.length; i++)
        // {
        //     if (nums[i] == 0)
        //         zCount++;
        //     else
        //         numsIneqZero.add(nums[i]);
        // }
        // for (int i = 0; i < nums.length; i++)
        // {
        //     if (i < numsIneqZero.size())
        //         nums[i] = numsIneqZero.get(i);
        //     else
        //         nums[i] = 0;
        // }
        
    }
}
