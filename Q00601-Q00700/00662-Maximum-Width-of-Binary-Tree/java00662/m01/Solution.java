package java00662.m01;

import java00000.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-27 13:15
 * @Update Date Time: 2022-08-27 13:15
 * @Updated-By: alton_z
 * @Update-Location:
 * 662. Maximum Width of Binary Tree #444
 *
 *
 */
class Solution {
    Map<Integer, Integer> levelMin = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {

        // 开始递归找最大宽度,初始深度为 1， 从 1 索引位开始
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {

        // 当 node 为空， 宽度为 0
        if (node == null) {
            return 0;
        }


        // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        levelMin.putIfAbsent(depth, index);

        // 返回最大的宽度
        // 当前层宽度， left 最大宽度， right 最大宽度
        // 不断递归找到最大宽度
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}