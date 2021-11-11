class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.backtrack(result, nums, 0, [])
        return result

    def backtrack(self, result, nums, start, temp):
        result.append(copy.copy(temp))
        for index in range(start, len(nums)):
            temp.append(nums[index])
            self.backtrack(result, nums, index + 1, temp)
            del temp[-1]