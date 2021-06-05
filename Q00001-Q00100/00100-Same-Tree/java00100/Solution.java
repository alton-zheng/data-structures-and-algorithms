package java00100;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 10:09 PM
 * @Description:
 * 100. Same Tree #81
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 *
 * Time Complexity: O(min(M, N))
 * Space Complexity: O(min(M, N))
 *
 * bfs
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
 * Memory Usage: 38.4 MB, less than 6.10% of Java online submissions for Same Tree.
 */

import apple.laf.JRSUIUtils;
import java00082.ListNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            TreeNode l1 = node1.left, r1 = node1.right, l2 = node2.left, r2 = node2.right;

            if (l1 == null ^ l2 == null) {
                return false;
            }

            if (r1 == null ^ r2 == null) {
                return false;
            }

            if (l1 != null) {
                q1.add(l1);
            }

            if (r1 != null) {
                q1.add(r1);
            }

            if (l2 != null) {
                q2.add(l2);
            }

            if (r2 != null) {
                q2.add(r2);
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
