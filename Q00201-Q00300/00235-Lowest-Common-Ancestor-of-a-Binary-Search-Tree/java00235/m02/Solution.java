package java00235.m02;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-01 11:05
 * @Update Date Time: 2022-09-01 11:05
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 初始化 res 为 root tree
        TreeNode res = root;

        // res 不为 null 时，进入循环
        while (res != null) {

            if (p.val < res.val && q.val < res.val) {
                // p,q 都在左边
                res = res.left;
            } else if (p.val > res.val && q.val > res.val){
                // p,q 都在右边
                res = res.right;
            } else {

                // p,q 一左一右，返回当前 tree
                break;
            }
        }

        // 返回结果
        return res;
    }
}
