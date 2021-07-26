package java01713.m02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 2021/7/26 上午8:22
 * @Description:
 * 1713. Minimum Operations to Make a Subsequence
 *
 * You are given an array target that consists of distinct integers and another integer array arr that can have duplicates.
 *
 * In one operation, you can insert any integer at any position in arr. For example, if arr = [1,4,1,2], you can add 3 in the middle and make it [1,4,3,1,2]. Note that you can insert the integer at the very beginning or end of the array.
 *
 * Return the minimum number of operations needed to make target a subsequence of arr.
 *
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 *
 *
 *
 * Example 1:
 *
 * Input: target = [5,1,3], arr = [9,4,2,3,4]
 * Output: 2
 * Explanation: You can add 5 and 1 in such a way that makes arr = [5,9,4,1,2,3,4], then target will be a subsequence of arr.
 * Example 2:
 *
 * Input: target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= target.length, arr.length <= 10^5
 * 1 <= target[i], arr[i] <= 10^9
 * target contains no duplicates.
 *
 * Time Complexity: O(n + mlogm)
 * Space Complexity： O(n + m)
 */
class Solution {
    public int minOperations(int[] target, int[] arr) {
        // 定义 target 数组长度变量
        int len = target.length;

        // 定义维护 target 的 map （HashMap）
        Map<Integer, Integer> targetPostionInfo = new HashMap<>();

        // 将 target position 以及值信息在 targetPositionInfo 中进行维护
        for (int i = 1; i <= len; i++) {
            // [1,....len] 虚拟数字
            targetPostionInfo.put(target[i - 1], i);
        }

        // 定义 arr 中能在 target 能找到的元素对应的虚拟数字数组
        List<Integer> help = new ArrayList<>();

        // 开始遍历 arr
        for (int val : arr) {

            // 在 target 中能找到 val 值，意味着它时有效的
            if (targetPostionInfo.containsKey(val)) {
                // 找到 val 在 target 的虚拟数字位
                int cur = targetPostionInfo.get(val);

                // 当前 help 的 size
                int size = help.size();

                // 定义 binary search left, right 边界
                int left = 0, right = size - 1;

                // 当 help size 为 0 或者 help 的最大数都小于 cur 值时
                // 意味着可以直接写
                if (size == 0 || help.get(size - 1) < cur) {
                    left = size;
                    right = -1;
                }

                // 开始 binary search
                while (left < right) {

                    // 找到 mid
                    int mid = ((right - left) >> 1) + left;

                    // help mid 位置值 小于 cur 值时，意味着需要往右区间找
                    if (help.get(mid) < cur) {
                        left = mid + 1;
                    } else {
                        // 反之，左边找
                        right = mid;
                    }
                }

                // 这里仅涉及到 list 的操作位置
                if (left != help.size()) {
                    // 修改
                    help.set(left, cur);
                } else {
                    // 新增
                    help.add(cur);
                }
            }

            // 找到 target 中的值直接忽略，利于理解
        }
        return len - help.size();
    }

}
