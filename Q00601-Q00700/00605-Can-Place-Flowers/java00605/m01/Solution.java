package java00605.m01;

/**
 * @Author: alton
 * @Date: Created in 7/9/21 4:19 PM
 * @Description: 605. Can Place Flowers #189
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * <p>
 * Time Complexity : O(len)
 * Space Complexity : O(1)
 * Runtime: 1 ms, faster than 88.56% of Java online submissions for Can Place Flowers.
 * Memory Usage: 40.5 MB, less than 59.00% of Java online submissions for Can Place Flowers.
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int flowers = 0;
        int len = flowerbed.length;

        int before = -1;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                if (before < 0) {

                    // before < 0 ,意味着当前位置前没有任何花存在， 可以在最右边花左边种植 i / 2 多花
                    flowers += i / 2;
                } else {
                    // 最多可以在2多花中间范围内种植 (i − before −2)/2 朵花
                    flowers += (i - before - 2) / 2;
                }
                if (flowers >= n) {
                    return true;
                }
                before = i;
            }
        }

        if (before < 0) {

            // 如果花坛上没有任何花朵，则有 m 个位置可以种植花，最多可以种植 (len + 1) / 2 朵花。
            flowers += (len + 1) / 2;

        } else {

            // 下标 before 右边有 len − before − 1 个位置，可以种植花的位置数是 len − before − 2，最多可以种植 (len − before − 1) / 2 朵花
            flowers += (len - before - 1) / 2;

        }

        // 当 flowers 大于等于题目的 n, 则返回 true, 否则返回 false
        return flowers >= n;
    }
}
