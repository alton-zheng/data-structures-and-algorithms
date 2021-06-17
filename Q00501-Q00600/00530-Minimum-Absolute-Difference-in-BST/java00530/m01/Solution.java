package java00530.m01;

/**
 * @Author: alton
 * @Date: Created in 6/17/21 4:28 PM
 * @Description:
 *
 * 530. Minimum Absolute Difference in BST #120
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
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
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 *
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 * Time Complexity : O(N)
 * Space Complexity :O(N)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Absolute Difference in BST.
 * Memory Usage: 38.3 MB, less than 88.24% of Java online submissions for Minimum Absolute Difference in BST.
 *
 */
class Solution {
    int pre;
    int res;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        res = 100001;

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
