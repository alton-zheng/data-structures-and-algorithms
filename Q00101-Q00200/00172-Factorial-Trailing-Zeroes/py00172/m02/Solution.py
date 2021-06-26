# Runtime: 28 ms, faster than 91.24% of Python3 online submissions for Factorial Trailing Zeroes.
# Memory Usage: 14.2 MB, less than 72.79% of Python3 online submissions for Factorial Trailing Zeroes.
# Time Complexity : O(logN)
# Space Complexity : O(1)
class Solution:
    def trailingZeroes(self, n: int) -> int:
        res = 0
        power5 = 5
        while n >= power5:
            res += n // power5
            power5 *= 5

        return res