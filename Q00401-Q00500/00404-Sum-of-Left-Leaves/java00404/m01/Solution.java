package java00404.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/28 10:30 下午
 * @Description:
 * 404. Sum of Left Leaves
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
 * Memory Usage: 37.1 MB, less than 22.84% of Java online submissions for Sum of Left Leaves.
 *
 */

import java00000.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        // 为了更好的理解,分步写

        // 将空节点排除
        if (root == null) {
            // 默认 null 节点和为 0
            return 0;
        }

        int leftLeafValue = 0;
        // left leaf 值
        if (isLeftLeafNode(root)) {
            leftLeafValue  = root.left.val;
        }

        // left 树中 left leaf 值总和
        int l = sumOfLeftLeaves(root.left);

        // right 树中 left leaf 值总和
        int r = sumOfLeftLeaves(root.right);

        return leftLeafValue + l + r;

    }

    private boolean isLeftLeafNode(TreeNode node) {

        // 是否 left leaf 节点，需要满足 2 条件
        // 1. 当前节点的 left 节点不为空 2. left 节点不再有左右子节点
        if (node.left != null &&
                node.left.left == null &&
                node.left.right == null
        ) {
            return true;
        }

        // 其它情况均为 false
        return false;
    }
}
