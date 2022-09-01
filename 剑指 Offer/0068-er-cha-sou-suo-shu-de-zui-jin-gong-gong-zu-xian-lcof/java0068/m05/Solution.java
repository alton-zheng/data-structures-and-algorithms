package java0068.m05;

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 11:21
 * @Update Date Time: 2022-09-01 11:21
 * @Updated-By: alton_z
 * @Update-Location:
 * 方法一的递归版本
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        getPath(root, p, pathP);
        getPath(root, q, pathQ);

        TreeNode res = root;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            } else {
                break;
            }
        }

        return res;
    }

    private void getPath(TreeNode node, TreeNode target, List<TreeNode> list) {

        if (node == null) {
            return;
        }

        list.add(node);
        if (target.val > node.val) {
            getPath(node.right, target, list);
        } else if (target.val < node.val){
            getPath(node.left, target, list);
        }
    }
}
