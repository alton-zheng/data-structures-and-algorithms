package java00897.m01;

/**
 * @Author: alton
 * @Date: Created in 6/27/21 3:39 PM
 * @Description:
 * 897. Increasing Order Search Tree #153
 */

import java00897.TreeNode;

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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
 * Memory Usage: 36.6 MB, less than 50.22% of Java online submissions for Increasing Order Search Tree.
 */
class Solution {
    private TreeNode pre = new TreeNode(-1);
    private TreeNode temp = pre;
    public TreeNode increasingBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        increasingBST(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        increasingBST(root.right);

        return pre.right;
    }
}
