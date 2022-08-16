# Runtime: 52 ms, faster than 72.43% of Python3 online submissions for Third Maximum Number.
# Memory Usage: 14.9 MB, less than 71.99% of Python3 online submissions for Third Maximum Number.

class java00002.m01.Solution:
    def thirdMax(self, nums: List[int]) -> int:

        l  = len(nums)

        ## 长度小于等于 2 时，取最大值即可
        if l <= 2:
            return max(nums[0], nums[l - 1])

        first = second = third = float('-inf')

        for cur in nums :

            ## 由于第几大都是不能重复的，也就是说当前元素 cur 如果等于 first, second 时，忽略即可
            if cur == first or cur == second :
                ## 忽略当前元素
                continue

            ## 当前元素大于 first, 更新 first, second, third
            if cur > first:
                third = second
                second = first
                first = cur
                continue

            ## 当前元素大于 second, 更新 third, second 指针
            if cur > second:
                third = second
                second = cur
                continue

            ## 大于 third 时，更新 third 指针
            if cur > third :
                third = cur


        if third == float('-inf'):
            return first
        else :
            return third