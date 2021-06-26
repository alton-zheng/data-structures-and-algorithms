# Runtime: 28 ms, faster than 91.24% of Python3 online submissions for Factorial Trailing Zeroes.
# Memory Usage: 14.2 MB, less than 46.32% of Python3 online submissions for Factorial Trailing Zeroes.
# Time Complexity : O(logN)
# Space Complexity : O(1)
class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        while n > 0:
            n //= 5
            res += n
        return res