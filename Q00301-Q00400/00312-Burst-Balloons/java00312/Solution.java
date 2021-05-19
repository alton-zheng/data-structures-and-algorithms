package java00312;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 5/19/21 1:40 PM
 * @Description:
 * 312. Burst Balloons #20
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 500
 * 0 <= nums[i] <= 100
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 * 记忆化搜索
 */
class Solution2 {

    int[] search;
    int[][] help;
    public int maxCoins(int[] nums) {

        int numsLen = nums.length;
        search = new int[numsLen + 2];
        search[0] = search[numsLen + 1] = 1;

        help = new int[numsLen + 2][numsLen + 2];

        for (int i = 1; i <= numsLen; i++) {
            search[i] = nums[i - 1];
        }

        for (int i = 0; i <= numsLen + 1; i++) {
            Arrays.fill(help[i], -1);
        }

        return getCoins(0, numsLen + 1);
    }

    private int getCoins(int startIndex, int endIndex) {

        if (startIndex >= endIndex - 1) {
            return 0;
        }

        int cur = help[startIndex][endIndex];
        if (cur != -1) {
            return cur;
        }

        for (int i = startIndex + 1; i < endIndex; i++) {
            int sum = search[startIndex] * search[i] * search[endIndex];
            sum += getCoins(startIndex, i) + getCoins(i, endIndex);

            help[startIndex][endIndex] = Math.max(help[startIndex][endIndex], sum);
        }

        return help[startIndex][endIndex];

    }
}

/**
 * 以上方法，自顶向下，可以用动态规划的思想求出最大值（字底向上）
 * 思考一下，其实这个题， 戳破一个气球，将此气球和左右两，一起 3 气球的数值相乘
 * 意味着他们所在位置是不同的，start, mid ,end 3 个索引值组成
 * start < mid < end
 * DP 思想
 * 优化如下：
 */
class Solution {
    public int maxCoins(int[] nums) {

        int numsLen = nums.length;

        // 加 2 个位置，收尾为 1， 为了处理时不超出边界
        int[] search = new int[numsLen + 2];
        search[0] = search[numsLen + 1] = 1;

        // 存储在不同 start, end 时，能获取的最大 Coins 数
        int[][] help = new int[numsLen + 2][numsLen + 2];

        // search 数组，初始化（除收尾）
        for (int i = 1; i <= numsLen; i++) {
            search[i] = nums[i - 1];
        }


        // 倒数第二个索引位置开始，留位置给 mid, end
        for (int start = numsLen - 1; start >= 0; start--){

            // 至少比 start 大 2， 留出一个位给 mid
            for (int end = start + 2; end <= numsLen + 1; end++) {

                /**
                 * 请注意： mid 索引位置的气球是最后被戳破
                 * 它将 start, end 中间的气球，以 mid 位置，分成了两组气球，分而治之
                 * 虽然在此实现，并未分工合作
                 * 不断循环各个组合情况，求出最大值
                 */
                for (int mid = start + 1; mid < end; mid++) {
                    int sum = search[start] * search[mid] * search[end];
                    sum += help[start][mid] + help[mid][end];
                    help[start][end] = Math.max(help[start][end], sum);
                }
            }
        }

        return help[0][numsLen + 1];
    }
}
