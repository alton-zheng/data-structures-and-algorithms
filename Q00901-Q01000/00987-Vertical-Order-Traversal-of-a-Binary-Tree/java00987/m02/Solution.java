package java00987.m02;

import java00000.TreeNode;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 2021/7/31 12:12 上午
 * @Description:
 */
class Solution {

    // 定义 col 数量
    private int minCol = 0, maxCol = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        /**
         * 这里用 List 包装 int[] ，在添加元素先不进行自排序，提升性能
         * 数组中 ，包含 {col, row, val}, 与题排序优先级保持一致
         * 这里的数组也可以用类结构，在类中定义属性和排序规则
         */
        List<int[]> position = new ArrayList<>();

        // 递归相对于迭代，Morris 写法更优雅，这里选择它
        // 可以更好的理解这道题
        // root 树， 按题意 row, col 坐标都为 0， 第三个参数传 postion
        dfs(root, 0, 0, position);

        // 添加元素后，先对 position 作整体排序，col -> row -> val
        Collections.sort(position,
                (a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]
        );

        // 递归完后，定义 res 变量
        List<List<Integer>> res = new ArrayList<>();

        int cols = Math.abs(maxCol - minCol) + 1;
        for (int i = 1; i <= cols; i++) {
            res.add(new ArrayList<>());
        }

        // 因为 position 已经全局排序， 按 col -> row -> val 的优先级已经排序，
        // 不断的添加元素即可
        for (int[] arr: position) {
            res.get(arr[0] - minCol).add(arr[2]);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> position) {

        // 节点为空时，没意义，直接返回
        if (node == null) {
            return;
        }

        // 获取最小的列数
        minCol = Math.min(col, minCol);
        maxCol = Math.max(col, maxCol);

        // 将 col , row ， node val 构成数组添加到 position list 中
        position.add(new int[] {col, row, node.val});

        // 递归遍历 node left
        dfs(node.left, row + 1, col - 1, position);
        // 递归遍历 node right
        dfs(node.right, row + 1, col + 1, position);
    }
}
