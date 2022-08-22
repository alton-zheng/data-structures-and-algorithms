package java00655.m01;

import java00000.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-22 14:07
 * @Update Date Time: 2022-08-22 14:07
 * @Updated-By: alton_z
 * @Update-Location:
 * 655. Print Binary Tree #441
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，
 * 用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2^(height+1) - 1 。
 * 根节点 需要放置在顶行的正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，
 * 将其左子节点放置在 res[r+1][c-2^(height-r-1)] ，
 * 右子节点放置在 res[r+1][c+2^(height-r-1)] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 210] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 *
 */

/* *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {

        // 得到 tree 的深度
        int height = getHeight(root);

        // 按题意得到结果集行数
        int m = height + 1;

        // 按题意得到结果集列数
        int n = (1 << (height + 1)) - 1;

        // 定义结果集数据结构 二维 List
        List<List<String>> res = new ArrayList<>();

        // 将结果集默认值为 ""
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }

        // 深度递归，按题意赋值
        // root.val 放入首行的 (n -1)/2 列位置
        dfs(res, root, 0, (n - 1) / 2, height);

        // 返回结果集
        return res;
    }

    // 获取树高度，这里也适用深度优先算法 - 递归来实现
    public int getHeight(TreeNode node) {
        int height = 0;

        // 判断 left 树
        if (node.left != null) {
            height = Math.max(height, getHeight(node.left) + 1);
        }
        if (node.right != null) {
            height = Math.max(height, getHeight(node.right) + 1);
        }

        // 递归取最大的 height 值，并返回
        return height;
    }

    /**
     * 深度优先算法， 将树的值放入符合题意的位置
     * @param res
     * @param node
     * @param r
     * @param c
     * @param height
     */
    public void dfs(List<List<String>> res, TreeNode node, int r, int c, int height) {

        // 真正将 node.val 赋值到 res 中的代码
        // 将 node.val 放入到 r 行， c 列位置
        // 并将值字符串化
        res.get(r).set(c, Integer.toString(node.val));

        // node.left 不为空时
        if (node.left != null) {
            // 将左子树进行 dfs, 左树值放入到符合题意的 r + 1 行 c - (1 << (height - r - 1)) 列位置
            // 继续递归右树
            dfs(res, node.left, r + 1, c - (1 << (height - r - 1)), height);
        }

        // 判断 node 右树是否为空
        if (node.right != null) {

            // 将右子树进行 dfs, 右树值值放入到符合题意的 r + 1 行， c + (1 << (height - r -1)) 列位置
            // 继续递归右树
            dfs(res, node.right, r + 1, c + (1 << (height - r - 1)), height);
        }
    }

}
