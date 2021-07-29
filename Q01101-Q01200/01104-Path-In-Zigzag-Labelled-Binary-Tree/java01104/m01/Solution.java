package java01104.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/7/29 8:32 上午
 * @Description:
 * 1104. Path In Zigzag Labelled Binary Tree #250
 *
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.
 *
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.
 *
 *
 *
 * Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.
 *
 *
 *
 * Example 1:
 *
 * Input: label = 14
 * Output: [1,3,4,14]
 * Example 2:
 *
 * Input: label = 26
 * Output: [1,2,6,10,26]
 *
 *
 * Constraints:
 *
 * 1 <= label <= 10^6
 *
 * Time Complexity: O(logLabel)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> res = new ArrayList<>();

        // 为了更好的理解解题思路，下面代码不写的太抽象，尽量跟思路中描述的保持一致
        // label 为 1 时，直接返回
        if (label == 1) {
            res.add(1);
            return res;
        }

        // 找到所在层级
        int level = 1;
        int init = 1;
        while (init << 1 <= label) {
            level++;
            init <<= 1;
        }

        // 构建出尾元素
        res.add(label);


        for (int i = level - 1; i > 1; i--) {
            int cur = label >> 1;
            res.add(0, i % 2 != level % 2 ? (1 << (i - 1)) + (1 << i) - 1 - cur: cur);
            label = cur;
        }

        // 最后将 1 添加进结果集
        res.add(0, 1);

        return res;

    }
}