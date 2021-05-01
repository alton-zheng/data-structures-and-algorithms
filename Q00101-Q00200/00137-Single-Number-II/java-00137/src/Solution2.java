/**
 * 复杂度分析：
 * 时间复杂度 O(N) ： 其中 N 为数组 nums 的长度；遍历数组占用O(N)，每轮中的常数个位运算操作占用 `O(32 * 3 * 2) = O(1)` 。
 * 空间复杂度 O(1) ： 变量 ones , twos 使用常数大小的额外空间。
 */
class Solution2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}