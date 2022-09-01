package java0086.m01;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 14:40
 * @Update Date Time: 2022-09-01 14:40
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getHelp(root, p, q).tree;
    }

    private Help getHelp(TreeNode node, TreeNode p, TreeNode q) {


        // 边界条件， node == null 时，返回默认的 help 实例
        if (node == null) {
            return new Help(false, false, node);
        }

        // left
        Help left = getHelp(node.left, p, q);

        // right
        Help right = getHelp(node.right, p, q);

        // 判断 findP
        boolean findP = node == p || left.findP || right.findP;

        // 判断 findQ
        boolean findQ = node == q || left.findQ || right.findQ;

        // tree
        TreeNode tree = null;

        // tree 取数逻辑, left, right 有 tree 直接取他们
        if (left.tree != null) {
            tree = left.tree;
        } else if (right.tree != null) {
            tree = right.tree;
        } else {
            // 如果 p,q 都找到了，直接将 node 赋值给 tree
            if (findP && findQ) {
                tree = node;
            }
        }

        return new Help(findP, findQ, tree);
    }

    class Help {
        public TreeNode tree;
        public boolean findP, findQ;
        public Help (boolean findP, boolean findQ, TreeNode tree) {
            this.findP = findP;
            this.findQ = findQ;
            this.tree = tree;
        }
    }
}
