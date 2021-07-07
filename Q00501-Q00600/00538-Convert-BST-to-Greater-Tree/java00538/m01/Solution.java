package java00538.m01;

/**
 * @Author: alton
 * @Date: Created in 7/6/21 3:39 PM
 * @Description:
 *
 * 538. Convert BST to Greater Tree
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * Example 2:
 *
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 * Example 3:
 *
 * Input: root = [1,0,2]
 * Output: [3,3,2]
 * Example 4:
 *
 * Input: root = [3,2,4,1]
 * Output: [7,9,4,10]
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
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
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert BST to Greater Tree.
 * Memory Usage: 39.4 MB, less than 46.93% of Java online submissions for Convert BST to Greater Tree.
 */
class Solution {
    private int max = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        root.right = convertBST(root.right);
        root.val += max;
        max = root.val;
        root.left = convertBST(root.left);
        return root;
    }
}
