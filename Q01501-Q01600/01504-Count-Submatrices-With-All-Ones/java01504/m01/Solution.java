package java01504.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-09 23:58
 * @Update Date Time: 2022-09-09 23:58
 * @Updated-By: alton_z
 * @Update-Location:
 * 1504. Count Submatrices With All Ones #471
 * https://leetcode.cn/problems/count-submatrices-with-all-ones/
 */
class Solution {

    public int numSubmat(int[][] mat) {

        /**
         * 边界条件：
         * 1. 数组为空
         * 2. 数组长度为 0
         */
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        // 定义结果变量
        int res = 0;

        // 定义 height 数组
        int[] height = new int[mat[0].length];

        // 开始遍历二维矩阵
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                /**
                 * 更新 height 数组对应位
                 * 1. 当前矩阵位如果为 0， height 对应位，直接复原成 0（碰到 0， 意味着当前位上没有高度）
                 * 2. 不为 0， 原 height + 1 赋值给 height 对应位数组
                 */
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }

            // 每次遍历完一层， 统计一层所有的数量
            // 并将结果值赋值给 res
            res += countFromBottom(height);

        }

        // 返回 res
        return res;

    }

    // 比如
    //              1
    //              1
    //              1         1
    //    1         1         1
    //    1         1         1
    //    1         1         1
    //
    //    2  ....   6   ....  9
    // 如上图，假设在6位置，1的高度为6
    // 在6位置的左边，离6位置最近、且小于高度6的位置是2，2位置的高度是3
    // 在6位置的右边，离6位置最近、且小于高度6的位置是9，9位置的高度是4
    // 此时我们求什么？
    // 1) 求在3~8范围上，必须以高度6作为高的矩形，有几个？
    // 2) 求在3~8范围上，必须以高度5作为高的矩形，有几个？
    // 也就是说，<=4的高度，一律不求
    // 那么，1) 求必须以位置6的高度6作为高的矩形，有几个？
    // 3..3  3..4  3..5  3..6  3..7  3..8
    // 4..4  4..5  4..6  4..7  4..8
    // 5..5  5..6  5..7  5..8
    // 6..6  6..7  6..8
    // 7..7  7..8
    // 8..8
    // 这么多！= 21 = (9 - 2 - 1) * (9 - 2) / 2
    // 这就是任何一个数字从栈里弹出的时候，计算矩形数量的方式
    public static int countFromBottom(int[] height) {

        // 判断边界条件：
        // height 数组为 null
        // height 的长度为 0
        // 直接返回 0
        if (height == null || height.length == 0) {
            return 0;
        }

        // 定义 nums ， 默认为 0
        int nums = 0;

        // 使用数组代替 stack 结构，来降低复杂度常数系数，提升性能
        // 长度为 height 的长度
        int[] stack = new int[height.length];

        // stack index , 初始化为 -1
        int stackIndex = -1;

        // 开始遍历 height 数组
        for (int i = 0; i < height.length; i++) {

            // 初次不会进入这里， stackIndex 为 -1
            // 从第二个元素开始 while 循环判断，第二个元素进入这里判断时 stackIndex 为 0
            // height stack 顶索引位元素 >= height[i]
            while (stackIndex != -1 && height[stack[stackIndex]] >= height[i]) {

                // 弹出 stack 元素，在这里直接取 stackIndex 位的数组值即可
                // stackIndex--
                int cur = stack[stackIndex--];

                // 当 height[cur] > height[i]
                if (height[cur] > height[i]) {

                    // 当 stackIndex 回到 -1 , 将 -1 赋值给 left
                    // 否则将上一个栈顶元素下一位索引 -> left
                    int left = stackIndex == -1 ? -1 : stack[stackIndex];

                    int n = i - left - 1;

                    // 1. 当 left 为 -1 时，说明栈里没有元素了，取 0，  否则取 height[left]
                    // 2. height[i]
                    // 取 1， 2 中的大值赋值给 down
                    int down = Math.max(left == -1 ? 0 : height[left], height[i]);

                    // 按照题意含义， 将符合条件的 1 矩形个数加给 nums
                    nums += (height[cur] - down) * num(n);
                }

            }

            // height 首元素赋值为 i， stackIndex -> 0
            // 将 i 索引压入栈
            stack[++stackIndex] = i;
        }

        // 到最后， 如果 stackIndex 不为 -1
        // 意味着 stack 不为空，继续逻辑处理
        while (stackIndex != -1) {

            // 当前索引位
            int cur = stack[stackIndex--];

            // left
            int left = stackIndex == -1  ? -1 : stack[stackIndex];

            // n 代表着 height 中有多少符合 1 的条件
            int n = height.length - left - 1;

            // down 为 height[left] 值
            int down = left == -1 ? 0 : height[left];

            // nums 加上将符合题意的数量
            nums += (height[cur] - down) * num(n);
        }

        // 返回结果
        return nums;
    }

    public static int num(int n) {
        return ((n * (1 + n)) >> 1);
    }

}
