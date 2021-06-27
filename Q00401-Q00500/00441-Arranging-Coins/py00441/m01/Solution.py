# Runtime: 1264 ms, faster than 18.40% of Python3 online submissions for Arranging Coins.
# Memory Usage: 14.3 MB, less than 35.72% of Python3 online submissions for Arranging Coins.
class Solution:
    def arrangeCoins(self, n: int) -> int:

        level = 0
        help = 1

        while n >= help:
            n -= help
            help += 1
            level += 1

        return level