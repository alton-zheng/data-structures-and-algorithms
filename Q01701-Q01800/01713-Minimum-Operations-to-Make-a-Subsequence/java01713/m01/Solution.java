package java01713.m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Integer> arrList = new ArrayList<>();

        for (int val : arr) {

            if (targetPostionInfo.containsKey(val)) {
                int cur = targetPostionInfo.get(val);
                arrList.add(cur);
            }

            // 找不到的元素直接排除， 不考虑它

        }

        // 当 arr 中没有一个元素等于 target 元素时，直接返回 len
        if (arrList.size() == 0) {
            return len;
        }

        // 定义动态规划数组
        int[] dp = new int[arrList.size()];

        // 初始状态， 只需要一个元素时，有且仅有长度为1 的子序列
        dp[0] = 1;

        // 定义最长公共子序列长度为 1
        int res = 1;

        // 开始动态规划
        for (int i = 1; i < arrList.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 当 0 <= j < i ， arr[j] < arr[i] 时，说明当前 arr[i] 相对于 arr[j] 来说
                // 符合单调递增规则
                if (arrList.get(j) < arrList.get(i)) {

                    // 取 i 位置时的最长子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 取不同位置的最长公共子序列长度
            res = Math.max(res, dp[i]);
        }

        // 需要的操作数等于 len - res, 将它返回
        return len - res;
    }
}
