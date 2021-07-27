package java00671.m03;

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
 * Space Complexity: O(1)
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
 * inorder + Morris 变种
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
 * Memory Usage: 36.6 MB, less than 31.30% of Java online submissions for Second Minimum Node In a Binary Tree.
 */
class Solution {

    public int findSecondMinimumValue(TreeNode root) {

        /**
         * 根据题意： 一个节点的根是其所有子节点的最小值
         * 因此根节点是二叉树中的最小值
         */
        int res = -1, minValue = root.val;

        // 定义当前节点 cur ，初始化为 root
        TreeNode cur = root;

        while (cur != null) {

            /**
             * cur 左树为空，将其 val 进行判断，是否符合 res 的更新逻辑
             * 符合条件将当前节点 val 更新到 res, , `cur` 指向其右子树 `right` 节点 （cur = cur.right）
             */
            if(cur.left == null) {
                if (cur.val > minValue) {
                    // res 还未赋值，直接赋值为 cur.val
                    // 已赋值，取最小值
                    res = res == -1 ? cur.val : Math.min(res, cur.val);
                }

                cur = cur.right;
            } else {

                // 如果左子树不为空， 找 predecessor 节点
                TreeNode predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }

                // 下面对应描述中的 2 种场景
                // predecessor.right 为空
                if (predecessor.right == null) {
                    // 将 predecessor.right 与 cur 建立链接
                    predecessor.right = cur;

                    // 当前节点指向其 left 树
                    cur = cur.left;

                } else {

                    // 不为空时
                    if (cur.val > minValue) {
                        // res 还未赋值，直接赋值为 cur.val
                        // 已赋值，取最小值
                        res = res == -1 ? cur.val : Math.min(res, cur.val);
                    }
                    predecessor.right = null;
                    cur = cur.right;

                }
            }
        }

        // 返回结果值
        return res;
    }

}
