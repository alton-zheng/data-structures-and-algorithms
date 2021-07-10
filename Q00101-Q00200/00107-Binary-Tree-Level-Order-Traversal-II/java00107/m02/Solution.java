package java00107.m02;

import java00000.TreeNode;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 7/10/21 6:26 PM
 * @Description:
 * 107. Binary Tree Level Order Traversal II #193
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
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
 * Time Complexity: O(n)
 * Space Complexity : O(n)
 * dfs
 * Runtime: 1 ms, faster than 86.03% of Java online submissions for Binary Tree Level Order Traversal II.
 * Memory Usage: 40.2 MB, less than 7.15% of Java online submissions for Binary Tree Level Order Traversal II.
 */
class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

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
