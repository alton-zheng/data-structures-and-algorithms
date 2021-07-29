class Solution {
public:
    vector<int> pathInZigZagTree(int label) {

        // 为了更好的理解解题思路，下面代码不写的太抽象，尽量跟思路中描述的保持一致
        // label 为 1 时，直接返回
        if (label == 1) {
            return {1};
        }

        // 找到所在层级
        int level = 1;
        int init = 1;
        while (init << 1 <= label) {
            level++;
            init <<= 1;
        }

        vector<int> res(level);
        // 构建出尾元素
        res[level - 1] = label;

        // C++ vector 类似 java 数组处理， 可以提前将首元素 1 添加进去
        res[0] = 1;

        for (int i = level - 1; i > 1; i--) {
            int cur = label >> 1;
            res[i - 1] = i % 2 != level % 2 ? (1 << (i - 1)) + (1 << i) - 1 - cur: cur;
            label = cur;
        }

        return res;
    }
};