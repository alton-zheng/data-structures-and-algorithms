package java00107.m01;

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 *Runtime: 1 ms, faster than 86.03% of Java online submissions for Binary Tree Level Order Traversal II.
 * Memory Usage: 40 MB, less than 14.25% of Java online submissions for Binary Tree Level Order Traversal II.
 * bfs
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();

        // 树为空时，返回空 list
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            // 遍历当前层级所有节点，将节点值添加到 level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;

                // left right 不为空， 才将对应节点添加到 queue 中
                if (left != null) {
                    queue.offer(left);
                }

                if (right != null) {
                    queue.offer(right);
                }
            }

            // 这里是关键，保证 level, 从底到上存储
            res.add(0, level);
        }
        return res;
    }
}
