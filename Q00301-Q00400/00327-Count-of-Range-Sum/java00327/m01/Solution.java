package java00327.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-23 09:46
 * @Update Date Time: 2022-08-23 09:46
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 327. Count of Range Sum #442
 *
 * Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.
 *
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.
 *
 * Example 1:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2
 * Output: 3
 * Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
 * Example 2:
 *
 * Input: nums = [0], lower = 0, upper = 0
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * -105 <= lower <= upper <= 105
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

        // 边界条件，数组为空或数组长度为0，也就是数组没元素时，直接返回 0 即可
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        // preSum  前缀和，长度与 nums 长度保持一致
        long[] preSum = new long[len];

        // 初始化 preSum 的首元素，值为 nums[0]
        preSum[0] = nums[0];

        // 遍历数组，preSum 所有元素赋值
        // preSum[i] = preSum[i - 1] + nums[i]
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        // 开始流程处理，接下来的流程和原数组 nums 没有关系
        return process(preSum, 0, len - 1, lower, upper);
    }

    private int process(long[] preSum, int left, int right, int lower, int upper) {

        // 梳理边界条件，当 left == right 时，只要考虑当前位置是否在 [lower, upper]范围即可
        if (left == right) {
            return preSum[left] >= lower && preSum[left] <= upper ? 1 : 0;
        }

        // 定义 mid 值
        int mid = ((right - left) >> 1) + left;

        // 开始递归求符合题意的子数组对
        return process(preSum, left, mid, lower, upper)
                + process(preSum, mid + 1, right, lower, upper)
                + merge(preSum, left, mid, right, lower, upper);

    }

    /**
     * 开始归并排序并求和符合题意的子数组数
     */
    private int merge(long[] preSum, int left, int mid, int right, int lower, int upper) {

        // 定义结果变量 res
        int res = 0;

        // 定义双指针, 都指向 left 位置
        int L = left;
        int R = left;

        // [L, R)
        // 因为 [mid + 1, right] 位置前缀和递增的，他们分别减去相同的 lower, upper 得到 min, max
        // 因此 L，R 在循环的过程中，只会不断的递增，不会变小，所以 L，R 不需要每次都从 left 开始递增
        for (int i = mid + 1; i <= right; i++) {

            // preSum[i] 为 i 位置作为结尾的前缀和
            // min 将前缀和减去了 upper , 意味着只要前面的前缀和大于等于 min
            long min = preSum[i] - upper;
            // max 将前缀和减去了 lower , 意味着只要前面的前缀和小于等于 max
            long max = preSum[i] - lower;

            // 满足上述条件的个数就是当前位置的结果
            // 意味着只要前面的前缀和小于等于 max
            // 不断的将 R 右移，找到满足条件最大位置 [R, i]
            while (R <= mid && preSum[R] <= max) {
                R++;
            }

            // 意味着只要前面的前缀和大于等于 min
            // 小于 min 的 L 位置不会满足 upper 边界, 因此不断的将不满足的 L 位置右移
            // 最大的 L 位置 [L, i]
            while (L <= mid && preSum[L] < min) {
                L++;
            }

            // 加上当前位置符合条件的子数组个数
            res += R - L;
        }

        // 下面的逻辑，和普通的归并排序代码是一致的
        // 定义辅助函数 help
        long[] help = new long[right - left + 1];

        // 定义 help 数组索引变异量
        int i = 0;

        // l 从 left 开始
        int l = left;

        // r 从 mid + 1 位置开始
        int r = mid + 1;

        // l,r 双方都不越界的场景
        while (l <= mid && r <= right) {
            // 赋值 help
            help[i++] = preSum[l] <= preSum[r] ? preSum[l++] : preSum[r++];
        }

        // r 越界了， l 没有越界
        while (l <= mid) {
            help[i++] = preSum[l++];
        }

        // l 越界， r 没越界
        while (r <= right) {
            help[i++] = preSum[r++];
        }

        // 重新赋值 preSum
        for (i = 0; i < help.length; i++) {
            preSum[left + i] = help[i];
        }

        // 返回满足题意的子数组和
        return res;
    }
}