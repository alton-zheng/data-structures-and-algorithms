package java01302.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-17 20:40
 * @Update Date Time: 2022-08-17 20:40
 * @Updated-By: alton_z
 * @Update-Location:
 * https://leetcode.cn/problems/deepest-leaves-sum/
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * 1302. Deepest Leaves Sum #429
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
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

    int maxLevel = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        // 深度优先遍历
        dfs (root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        // 定义边界
        if (node == null) {
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
            sum = node.val;
        } else if (level == maxLevel) {
            sum += node.val;
        }

        // 遍历左节点
        dfs(node.left, level + 1);

        // 遍历右节点
        dfs(node.right, level + 1);

    }
}
