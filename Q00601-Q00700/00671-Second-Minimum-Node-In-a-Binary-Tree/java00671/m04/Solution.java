package java00671.m04;

/**
 * @Author: alton
 * @Date: Created in 2021/7/27 8:14 上午
 * @Description:
 * 671. Second Minimum Node In a Binary Tree #244
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 *
 *
 * Input: root = [2,2,2]
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 25].
 * 1 <= Node.val <= 2^31 - 1
 * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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
 * inorder + recursion
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
 * Memory Usage: 36.6 MB, less than 31.30% of Java online submissions for Second Minimum Node In a Binary Tree.
 */
class Solution {

    private int res = -1, minValue;
    public int findSecondMinimumValue(TreeNode root) {

        /**
         * 根据题意： 一个节点的根是其所有子节点的最小值
         * 因此根节点是二叉树中的最小值
         */
        minValue = root.val;

        // dfs -> preorder
        inorder(root);

        // 返回结果值
        return res;
    }

    /**
     * dfs -> inorder
     * @param node
     */
    private void inorder(TreeNode node) {

        // 当节点为空时，不需要任何处理
        if (node == null) {
            return;
        }

        // 当 res 已赋值，且当前节点 val 大于 res 时，其值是不符合第二小的要求的
        // 直接返回即可
        if (res != -1 && node.val >= res) {
            return;
        }

        // 递归 left
        inorder(node.left);

        // 结合上面代码和此条件，可以判断出，当前值不等于最小值，且比之前的 res 要小
        // 更新 res 值
        if (node.val > minValue) {
            res = node.val;
        }

        // 递归 right
        inorder(node.right);
    }
}
