package java00257.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/27 4:46 下午
 * @Description:
 *
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
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
 */
class Solution {

    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();

        dfs(root, "");

        return res;
    }

    private void dfs(TreeNode node, String s) {
        if (node == null) {
            return;
        }

        if (s == "") {
            s += node.val;
        } else {
            s += "->" + node.val;
        }

        if (node.left == null && node.right == null) {

            res.add(s);
        }

        dfs(node.left, s);
        dfs(node.right, s);
    }
}
