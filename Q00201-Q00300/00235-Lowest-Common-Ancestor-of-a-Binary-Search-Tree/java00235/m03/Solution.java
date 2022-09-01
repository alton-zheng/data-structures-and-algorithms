package java00235.m03;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 11:21
 * @Update Date Time: 2022-09-01 11:21
 * @Updated-By: alton_z
 * @Update-Location:
 * 实际找到 p,q 的方式
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getHelp(root, p, q).tree;
    }

    private Help getHelp(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return new Help(false, false, node);
        }
        Help left = getHelp(node.left, p, q);
        Help right = getHelp(node.right, p, q);

        boolean findP = node == p || left.findP || right.findP;
        boolean findQ = node == q || left.findQ || right.findQ;

        TreeNode tree = null;

        if (left.tree != null) {
            tree = left.tree;
        } else if (right.tree != null) {
            tree = right.tree;
        } else {
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
