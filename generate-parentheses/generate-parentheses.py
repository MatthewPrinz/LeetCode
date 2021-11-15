class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self.backtrack(n, 0, 0, result, "")
        return result
    def backtrack(self, n, open_int, close, result, temp):
        if close == n:
            result.append(temp)
        if open_int < n:
            self.backtrack(n, open_int + 1, close, result, temp + "(")
        if close < open_int:
            self.backtrack(n, open_int, close + 1, result, temp + ")")
            