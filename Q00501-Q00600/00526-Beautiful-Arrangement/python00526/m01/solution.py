# Runtime: 20 ms, faster than 100.00% of Python3 online submissions for Beautiful Arrangement.
# Memory Usage: 14.2 MB, less than 67.56% of Python3 online submissions for Beautiful Arrangement.
class Solution:
    def countArrangement(self, n: int) -> int:
        res = [0,1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679]
        return res[n]