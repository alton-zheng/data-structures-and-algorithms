package java00998.m01;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-30 16:49
 * @Update Date Time: 2022-08-30 16:49
 * @Updated-By: alton_z
 * @Update-Location:
 *
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        // 定义 null parent 树
        TreeNode parent = null;

        // cur -> root
        TreeNode cur = root;


        // cur 不为空进入循环
        // 首次，意味着 root 不为空
        while (cur != null) {

            // val 大于当前节点值时
            if (val > cur.val) {

                // 每当 val 大于 cur.val 时， 说明已经确认了 val 应该放置的位置
                // 根据不同的场景处理后直接返回结果


                // 如果 parent 为空
                if (parent == null) {

                    // 只有可能是第一次进来循环的场景
                    // 意味着此时 val 比 root 节点还大
                    // 直接重建一颗以 val 为 root 节点， root 为子树的树
                    return new TreeNode(val, root, null);
                }

                // 新建一颗以 val 为 root 节点， cur 为子树的树
                TreeNode node = new TreeNode(val, cur, null);

                // parent.right -> node 节点
                parent.right = node;

                // 返回 root 节点
                return root;
            } else {

                // val <= cur.val 时
                // parent -> cur
                parent = cur;

                // cur -> cur.right
                cur = cur.right;
            }
        }

        // cur 为空
        // 场景1： root 为空
        // 场景2； root 不为空， 但所有的right 节点都大于或等于 val,
        // 将它挂在 parent.right 右树上就好
        parent.right = new TreeNode(val);
        return root;
    }
}
