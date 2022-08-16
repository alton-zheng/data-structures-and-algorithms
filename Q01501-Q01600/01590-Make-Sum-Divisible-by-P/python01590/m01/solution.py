## Runtime: 508 ms, faster than 96.12% of Python3 online submissions for Make Sum Divisible by P.
## Memory Usage: 32.4 MB, less than 97.02% of Python3 online submissions for Make Sum Divisible by P.
class java00002.m01.Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:

        res = l = len(nums)
        mod = sum(nums) % p

        # 前缀和能被 p 整除时，不需要移除子数组，直接返回 0
        if mod == 0:
            return 0

        #  定义 hashmap, 添加初始值 {0: -1} ,代表着前缀余和 0， 所在的位置为 -1，[与数组为空的情况一样]
        hashmap = {0: -1}

        # 定义前缀和余
        sub_mod = 0

        for i, num in enumerate(nums):

            sub_mod = (sub_mod + num) % p
            target = (sub_mod - mod + p) % p
            if target in hashmap:
                res = min(res, i - hashmap[target])

                ## 如果 mod 等于当前元素的值，直接返回 1， 不需要继续遍历
                if res == 1 and res != l:
                    return res
            hashmap[sub_mod] = i

        # 不能将所有元素都移除，排除这种情况
        if res == l:
            res = -1

        return res