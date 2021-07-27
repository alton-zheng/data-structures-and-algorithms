package java01022.m01;

import java00000.TreeNode;

/**
 * @Author: alton
 * @Date: Created in 2021/7/27 10:30 上午
 * @Description:
 * 1022. Sum of Root To Leaf Binary Numbers #245
 *
 * You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 *
 * Input: root = [0]
 * Output: 0
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 * Example 4:
 *
 * Input: root = [1,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val is 0 or 1.
 *
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {
    // dfs, 定义 res
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {

        preOrder(root, 0);
        return res;
    }

    private void preOrder(TreeNode node, int parentSum) {
        if (node == null) {
            return;
        }

        // 二进制累计和
        int curSum = (parentSum << 1) + node.val;

        if (node.left == null && node.right == null) {
            // 此时的 node 为 leaf, 启动累计
            res += curSum;
            // 此时不需要继续往下走
            return;
        }

        // 递归 left, right, 他们的 parentSum 一致
        preOrder(node.left, curSum);
        preOrder(node.right, curSum);

    }
}
