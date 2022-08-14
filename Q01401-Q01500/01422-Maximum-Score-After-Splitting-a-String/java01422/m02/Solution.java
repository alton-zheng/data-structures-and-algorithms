package java01422.m02;

/**
 * 方法二，优化时间复杂度算法，一次遍历全搞定，优化算法中常数倍数
 * s 越长， 优化的时间越明显
 * 时间复杂度 O(N)
 */
class Solution {
    public int maxScore(String s) {

        // 将 String 化成 char 数组, 便于使用数组操作
        char[] sChar = s.toCharArray();

        // 定义字符长度变量，这里使用数组的长度对它初始化
        int len = sChar.length;

        // 定义左右得到变量
        // left -> 首 char '0' 为 1 为 1， 反之，为 0
        int left = sChar[0] == '0' ? 1 : 0;

        // 什么意思呢？ 其它字符得分为 0
        // 假设除首字符外其它字符没有 1 的场景
        int right = 0;

        // 定义结果变量 res, 将两边得到相加得到初始化 res
        int res = left + right;

        // 一次遍历，搞定
        // [1, len - 1]
        // 为啥遍历到 len - 1 呢？ 因为最后一位，肯定归于 right ， 先不考虑
        for (int i = 1; i < len - 1; ++i) {

            // 当前位置，进行右移
            // 左边串多一位，右边串少一位
            if (sChar[i] == '1') {

                // 字符为 '1'， 左边不得分，右边减分
                right--;

            } else {

                // 这种场景下，当前位置为 '0'
                // lift + 1, right 不得分
                // 将此场景下的得分相加， 和历史得分相加比较，最高分赋值给 res
                res = Math.max(res, ++left + right);
            }
        }

        // 看到这，大家会有一位， right 只减不加得到的结果肯定不对。
        // 解释下， 减多少分，不就意味着遍历到倒数第二位时， right 负多少次分不就等于 '1' 的个数么？
        // 那么上面的 res 得分还需要加上 [1, len] 位置所以 1 的个数才对
        // 因此 res 最终得分如下， right 为0 或为父，直接取它的正值即可得到 [1, len - 1] 1 的个数
        // 再加上最后一位的 right 得分
        return res - right + (sChar[len - 1] == '1' ? 1 : 0);
    }
}