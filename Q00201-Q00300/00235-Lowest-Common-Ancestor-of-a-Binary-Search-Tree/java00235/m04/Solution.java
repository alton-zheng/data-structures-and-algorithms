package java00235.m04;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 11:21
 * @Update Date Time: 2022-09-01 11:21
 * @Updated-By: alton_z
 * @Update-Location:
 * 递归方式，优化版本当然了，下面方式适合p, q 肯定存在的场景， 不然代码会复杂写
 * 根据实际情况，处理即可
 * 不需要实际找到 p, q
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > root.val && q.val > root.val) {
            root = lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            root = lowestCommonAncestor(root.left, p, q);
        }

        return root;

    }
}
