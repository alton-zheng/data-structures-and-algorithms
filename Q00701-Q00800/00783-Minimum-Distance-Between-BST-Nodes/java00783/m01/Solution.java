package java00783.m01;

/**
 * @Author: alton
 * @Date: Created in 6/17/21 3:21 PM
 * @Description:
 *
 * 783. Minimum Distance Between BST Nodes #119
 *
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 *
 *
 * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Time Complexity :O(N)
 * Space Complexity : O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
 * Memory Usage: 36.5 MB, less than 67.01% of Java online submissions for Minimum Distance Between BST Nodes.
 *
 */

import java00783.TreeNode;

/**
 * Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 */
class Solution {
    int pre;
    int res;

    public int minDiffInBST(TreeNode root) {
        pre = -1;
        res = 106;

        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (pre == -1) {
            pre = node.val;
        } else {
            res = Math.min(res, node.val - pre);
            pre = node.val;
        }
        dfs (node.right);
    }
}
