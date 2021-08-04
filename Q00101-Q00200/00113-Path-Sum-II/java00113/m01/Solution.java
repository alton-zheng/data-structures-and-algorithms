package java00113.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/4 5:39 下午
 * @Description:
 *
 * 113. Path Sum II #272
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *  
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
    Time Complexity: O(N)
    Space Complexity: O(N)

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

    private List<List<Integer>> res;
    private List<Integer> temp;
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        target = targetSum;

        dfs(root, 0);

        return res;
    }

    private void dfs (TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        int cur = node.val;
        temp.add(cur);

        if (node.left == null && node.right == null && sum + cur == target) {
            res.add(new ArrayList<>(temp));
        }

        dfs(node.left, sum + node.val);
        dfs(node.right, sum + node.val);

        temp.remove(temp.size() - 1);
    }
}
