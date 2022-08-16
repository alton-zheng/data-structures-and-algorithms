# Runtime: 40 ms, faster than 66.30% of Python3 online submissions for Arranging Coins.
# Memory Usage: 14.2 MB, less than 64.39% of Python3 online submissions for Arranging Coins.
class java00002.m01.Solution:
    def arrangeCoins(self, n: int) -> int:
        left = 1
        right = min([n, 66000])
        level =  n

        while right >= left:
            mid = left + (right - left)  // 2

            total = mid * (mid + 1) / 2
            if total > n:
                right = mid - 1
            else:
                left = mid + 1
                level = mid

        return level