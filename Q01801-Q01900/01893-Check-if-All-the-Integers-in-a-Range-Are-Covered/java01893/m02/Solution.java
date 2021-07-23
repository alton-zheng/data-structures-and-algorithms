package java01893.m02;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] help = new int[52];
        for (int[] range : ranges) {

            // first 位置比覆盖 first - 1 区间数量多 1
            help[range[0]]++;
            // second + 1 元素位置比覆盖 second 区间数量少 1
            help[range[1] + 1]--;
        }
        // 前缀和
        int preSum = 0;
        for (int idx = 1; idx <= right + 1; idx++) {
            preSum += help[idx];

            // 小于等于 0， 意味着覆盖 [left, right] 区间不完整，返回 false
            if (idx >= left && idx <= right && preSum <= 0) {
                return false;
            }
        }
        return true;
    }
}