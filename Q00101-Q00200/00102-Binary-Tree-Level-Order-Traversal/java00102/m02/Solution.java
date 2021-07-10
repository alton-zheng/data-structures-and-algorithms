package java00102.m02;

/**
 * @Author: alton
 * @Date: Created in 7/10/21 8:41 PM
 * @Description:
 *
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 * Time Complexity: O()
 * Space Complexity : O()
 *
 */

import java00000.TreeNode;

import java.util.*;

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

    private List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {

        res = new LinkedList<>();
        dfs(root, 0);

        Collections.reverse(res);

        return res;
    }

    private void dfs(TreeNode node, int level) {

        if (node == null) {
            return;
        }
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

    }

    public static void main(String[] args) {

    }
}