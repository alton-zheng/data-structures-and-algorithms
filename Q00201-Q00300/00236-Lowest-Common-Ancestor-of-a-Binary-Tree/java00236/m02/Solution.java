package java00236.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 17:26
 * @Update Date Time: 2022-09-01 17:26
 * @Updated-By: alton_z
 * @Update-Location:
 */

import java00000.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 开始递归，深度优先遍历
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        // 边界问题，如果 ans 已经赋值，不再继续往下走流程
        // 说明已经求出值了
        if (ans != null) {
            return false;
        }

        // root 为空时， 直接返回 false 就好
        if (root == null) {
            return false;
        }

        // 递归求 Lson, rson
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        // 场景1： 左右子树都有 p 或 q
        // 场景2： root 为 p 或 q, 且 root 子树有 p 或 q
        if ((lson && rson) || ((root == p || root == q) && (lson || rson))) {
            ans = root;
        }

        // 返回结果，只要 子树有 p 或 q 或者 root 等于 p 或 q 返回 true
        // 其余场景，返回 false
        return lson || rson || (root == p || root == q);
    }
}
