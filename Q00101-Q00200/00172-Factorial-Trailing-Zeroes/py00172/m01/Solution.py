# Runtime: 108 ms, faster than 39.63% of Python3 online submissions for Factorial Trailing Zeroes.
# Memory Usage: 14.1 MB, less than 72.79% of Python3 online submissions for Factorial Trailing Zeroes.
# Time Complexity : O(N)
# Space Complexity : O(1)
class Solution:
    def trailingZeroes(self, n: int) -> int:
        five_count = 0
        for i in range(5, n + 1, 5):
            power5 = 5
            while i % power5 == 0:
                five_count += 1
                power5 *= 5

        return five_count