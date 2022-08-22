package java00655.m02;

import java00000.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-22 14:25
 * @Update Date Time: 2022-08-22 14:25
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {


    /**
     * 定义 Tuple 辅助类，里边包含了 TreeNode 和 它所在 r, c
     */
    class Tuple {
        TreeNode node;
        int r;
        int c;

        public Tuple(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public List<List<String>> printTree(TreeNode root) {

        // 获得 height
        int height = getHeight(root);

        // 行数 m
        int m = height + 1;

        // 列数 n
        int n = (1 << (height + 1)) - 1;

        // 初始化 结果所有值为 ""
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }

        // 广度优先遍历算法来赋值 res,
        // 总体思路和获取 height 还有一些不同
        Queue<Tuple> queue = new ArrayDeque<>();

        // 使用 Tuple 实例来替代 tree node
        // 首先是将 root 节点构建的 Tuple 实例放入到队列中 offer
        queue.offer(new Tuple(root, 0, (n - 1) / 2));

        // 队列不为空时， 进行逻辑处理， 一次处理一个节点。 而不是每次循环处理一层的节点。
        // 当然了，这里也是符合广度优先策略的。 左右子树依次进入。FIFO 的策略
        // 明白了思路的话，它和一次 while 循环处理一层的没区别。while 循环的次数等于 TreeNode 的个数
        // 而不是层数，这样理解就没问题了
        // 如果习惯一次性处理一层，自己改造代码即可，没多大区别
        while (!queue.isEmpty()) {

            // queue 取出 poll
            Tuple t = queue.poll();

            // 取出 node
            TreeNode node = t.node;

            // 取出 r, c
            int r = t.r, c = t.c;

            // 直接赋值
            res.get(r).set(c, Integer.toString(node.val));

            // 左子树不为空时，将 Tuple 实例放入到 queue 中
            // 并将符合题意的 r, c 逻辑带入
            if (node.left != null) {
                queue.offer(new Tuple(node.left, r + 1, c - (1 << (height - r - 1))));
            }

            // 右子树不为空时，将 Tuple 实例放入到 queue 中
            // 并将符合题意的 r, c 逻辑带入
            if (node.right != null) {
                queue.offer(new Tuple(node.right, r + 1, c + (1 << (height - r - 1))));
            }
        }
        return res;
    }

    public int getHeight(TreeNode root) {
        int height = -1;

        // 利用队列的特性来辅助完成 TreeNode 宽度优先算法
        // 使用此数据结构来的都 height
        Queue<TreeNode> queue = new ArrayDeque<>();

        // 将当前 TreeNode root 节点放入到队列中
        queue.offer(root);

        // 开始对 queue 处理，只要 root 不为空，就会开始 while 循环处理
        while (!queue.isEmpty()) {
            // 一层层处理
            // 首次进入它的长度为 1， 只有 root 节点，也就是 level 0， 首层遍历
            // 每一层的所有 TreeNode, 每一次循环仅处理当前层的节点
            // 所有每次处理 len 个节点
            int len = queue.size();

            // 每次进入， height++
            height++;

            // len 长度大于 0，说明当前层是有树节点的， len 等于节点数， 从左到右开始遍历处理
            while (len > 0) {

                // 每次处理， len 减去 1
                len--;

                // 取出当前处理的 TreeNode node
                TreeNode node  = queue.poll();

                // 左子树不为空，则将左树添加到 queue 中
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // 右子树不为空，则将右树添加到 queue 中
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // 返回 height
        return height;
    }
}
