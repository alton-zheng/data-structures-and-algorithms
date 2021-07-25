package java0094.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/25 下午4:08
 * @Description:
 *
 * 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 */

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 37 MB, less than 88.31% of Java online submissions for Binary Tree Inorder Traversal.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {

    // 定义类级别变量， res 来存储结果集
    // 可以省略后续 inorder 方法中，将 res 置为参数的情况
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        // 将 root 进行中序遍历
        inorder(root);

        // 返回 res 结果集
        return res;
    }

    private void inorder(TreeNode node) {

        // 定义其边界情况， Tree 节点为空时， 直接返回，忽略
        if (node == null) {
            return;
        }

        // 递归 left 子树
        inorder(node.left);

        // 将 val 添加到结果集中
        res.add(node.val);

        // 递归 right 子树
        inorder(node.right);
    }
}
