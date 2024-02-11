object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map: Map[Int, Int] = Map()
        var result: Array[Int] = Array(0, 0)
        for (i <- 0 to nums.length - 1) {
            map = map + (nums(i) -> i)
        }
        for (i <- 0 to nums.length - 1) {
            if ((map contains (target - nums(i))) && (i != (map get (target - nums(i))).get)) {
                result(0) = i
                result(1) = (map get (target - nums(i))).get
            }
        }
        result
    }
}