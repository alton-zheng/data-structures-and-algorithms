package java0068.m01;

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 09:34
 * @Update Date Time: 2022-09-01 09:34
 * @Updated-By: alton_z
 * @Update-Location:
 * 二次遍历
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // pathP 保存 p 经过 TreeNode
        List<TreeNode> pathP = getPath(root, p);

        // pathQ 保存 q 经过 TreeNode
        List<TreeNode> pathQ = getPath(root, q);

        // 定义节点节点
        TreeNode res = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {

            // 找 lowest 公共祖先
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            } else {
                // 一旦经过节点不相等了，后面的经过的节点就不可能再次相等
                // 可以结束逻辑处理
                break;
            }
        }

        // 返回结果值
        return res;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {

        // 定义结果容器，这里使用 ArrayList 来处理
        List<TreeNode> ans = new ArrayList<>();
        // 定义指针
        TreeNode tree = root;
        while (tree != target) {

            // 添加每个经过的 tree
            ans.add(tree);

            // target 值 大于  tree 值，意味着 target 值在右边
            // 反之在左边
            if (target.val > tree.val) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }
        }

        // 添加 root
        // 或 target 点
        ans.add(tree);

        // 返回
        return ans;


    }
}
