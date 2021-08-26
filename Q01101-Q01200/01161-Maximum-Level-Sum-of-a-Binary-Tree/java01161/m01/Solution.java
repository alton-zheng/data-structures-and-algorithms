package java01161.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/26 8:29 上午
 * @Description:
 * 1161. Maximum Level Sum of a Binary Tree
 */

import java00000.TreeNode;

import java.util.Arrays;

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
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 10^4].
 * -105 <= Node.val <= 10^5
 *
 * Time Complexity: O(level)
 * Space Complexity: O(logN)
 * Runtime: 25 ms, faster than 5.81% of Java online submissions for Maximum Level Sum of a Binary Tree.
 * Memory Usage: 85.9 MB, less than 5.86% of Java online submissions for Maximum Level Sum of a Binary Tree.
 */
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
    private int[] help = new int[200002];
    private int maxLevel = 1;
    public int maxLevelSum(TreeNode root) {

        Arrays.fill(help, Integer.MIN_VALUE);
        dfs(root, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= maxLevel; i++) {
            max = Math.max(max, help[i]);
        }
        for (int i = 1; i <= maxLevel; i++) {
            if (help[i] == max) {
                return i;
            }
        }

        return 1;
    }

    private void dfs(TreeNode root, int level) {

        if (root == null) {
            maxLevel = Math.max(maxLevel, level);
            return;
        }

        if (help[level] == Integer.MIN_VALUE) {
            help[level] = root.val;
        } else {
            help[level] += root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}