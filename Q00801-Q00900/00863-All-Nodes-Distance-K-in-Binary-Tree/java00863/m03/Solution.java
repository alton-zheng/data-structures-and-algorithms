package java00863.m03;
import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 13 ms, faster than 97.56% of Java online submissions for All Nodes Distance K in Binary Tree.
 * Memory Usage: 39.1 MB, less than 52.49% of Java online submissions for All Nodes Distance K in Binary Tree.
 */
class Solution {

    // 定义结果值
    public List<Integer> res = new ArrayList<>();
    // 定义 k 变量（类全局有效）
    int dis;

    // 定义 target 全局 tar, 方便全局更改
    TreeNode tar;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 赋值 dis 为 k
        dis = k;

        // 根据题意，root 不可能为空，考虑 k 的 2 个边界即可
        if(dis == 0) {
            res.add(target.val);
            return res;
        }

        // 树节点范围 [0, 500], 当 k 大于它时，是不会存在结果集的
        if (dis > 501) {
            return res;
        }

        tar = target;

        // 将 target 树先处理完
        dfs(target,0);

        // target 遍历完后，将 target left, right 清空,仅保留 target 根
        target.left = target.right = null;

        /**
         * 将 root 其它树枝续接到 target 上
         * root 等于 target 时， 不需要进行此步骤
         */
        if(root != target){
            graft(root);
            dfs(tar,0);
        }
        return res;
    }

    private boolean graft(TreeNode node){

        // left, right 节点为空时， 不处理
        if(node == null) {
            return false;
        }

        // 找到与 target 相等的节点
        if(node == tar) {
            return true;
        }

        if(graft(node.left)){

            // 不断将父节点，续接到当前空节点上
            if(node.left.left == null){
                // 优先放 left 上
                node.left.left = node;
            } else if(node.left.right == null){
                node.left.right = node;
            }

            // 将 node left 置为 null
            node.left = null;

            return true;
        }

        if(graft(node.right)){

            // 不断将父节点，续接到当前空节点上
            if(node.right.left == null){
                // 优先放 left
                node.right.left = node;
            }else if(node.right.right == null){
                node.right.right = node;
            }
            // 将 node right 置为 null
            node.right = null;
            return true;
        }

        return false;
    }

    private void dfs(TreeNode node,int step){

        // node 为空时，不处理
        if(node == null) return;

        // 步数等于 k(dis), 将 node.val 添加到 res
        if(step == dis){
            res.add(node.val);
            // 够步数后，后续的步骤不需要
            return;
        }

        dfs(node.left, step + 1);
        dfs(node.right, step + 1);

    }
}