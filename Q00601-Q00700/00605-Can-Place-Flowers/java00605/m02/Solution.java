package java00605.m02;

/**
 * 跳格子法
 * 遇 1 跳 2 格
 * 遇 0 ：
 *  下格为 0，种花
 *  不为 0， 跳 3 格
 *  Runtime: 1 ms, faster than 88.56% of Java online submissions for Can Place Flowers.
 *  Memory Usage: 49 MB, less than 14.79% of Java online submissions for Can Place Flowers.
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;

        for (int i = 0; i < len && n > 0;) {

            if (n == 0) {
                return true;
            }
            // 说明当前地不能种花，调到下一可能能种花的地
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }

            // 说明此地能种花，种一朵花（n--）, 跳到下一可能种花的地
            if (i == len - 1 || flowerbed[i + 1] == 0) {
                i += 2;
                n--;
                continue;
            }

            // 当前位置为 0， 下一位置为 1 , 说明当前地不能种花，调到下一可能能种花的地
            i += 3;

        }

        return n <= 0;
    }
}