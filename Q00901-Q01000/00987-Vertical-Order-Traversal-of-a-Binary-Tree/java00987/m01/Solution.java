package java00987.m01;

import java00000.TreeNode;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 2021/7/31 12:12 上午
 * @Description:
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /**
         * 定义 map 数据结构来存储位置信息
         *
         * key 为 col 属性，与结果集中维度信息相称
         * 在 c++ 中 map 结构已经为 col 默认升序了
         * 在 java 中，我们用 TreeMap 来代替，进行自排序
         * value 为 {row, val} 对
         */
        Map<Integer, List<Integer[]>> position = new TreeMap<>();

        // 递归相对于迭代，Morris 写法更优雅，这里选择它
        // 可以更好的理解这道题
        // root 树， 按题意 row, col 坐标都为 0， 第三个参数传 postion
        dfs(root, 0, 0, position);

        // 递归完后，定义 res 变量
        List<List<Integer>> res = new ArrayList<>();

        // 遍历 postion
        List<Integer> cur;
        for (List<Integer[]> l: position.values()) {
            Collections.sort(l, (a, b) -> a[0].equals(b[0]) ? a[1] - b[1] : a[0] - b[0]);
            cur = new ArrayList<>();
            for (Integer[] rowValue: l) {
                cur.add(rowValue[1]);
            }
            res.add(cur);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<Integer[]>> position) {

        // 节点为空时，没意义，直接返回
        if (node == null) {
            return;
        }

        // 将 row ， node val 信息添加到 col 信息
        List<Integer[]> l = position.getOrDefault(col, new ArrayList<>());
        l.add(new Integer[]{row, node.val});
        position.put(col, l);

        // 递归遍历 node left
        dfs(node.left, row + 1, col - 1, position);
        // 递归遍历 node right
        dfs(node.right, row + 1, col + 1, position);
    }
}
