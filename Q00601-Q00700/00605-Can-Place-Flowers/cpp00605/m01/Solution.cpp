// Runtime: 16 ms, faster than 70.09% of C++ online submissions for Can Place Flowers.
// Memory Usage: 20 MB, less than 99.64% of C++ online submissions for Can Place Flowers.
class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int res = 0;
        // 由于花坛 left 加了 花和空地
        // 因此初始空地的个数为 1
        int zero = 1;

        for (int flower: flowerbed) {
            if (flower == 0) {
                zero++;
                continue;
            }

            // 再次遇到 花时，统计可以种的花数量
            res += (zero - 1) / 2;

            // 满足条件，则退出
            if (res >= n) {
                return true;
            }
            zero = 0;
        }

        // 花坛后边加了2块地，空地和花
        zero++;
        res += (zero - 1) / 2;
        return res >= n;
    }
};