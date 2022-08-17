package java01302.m02;


import java.util.ArrayDeque;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-17 20:58
 * @Update Date Time: 2022-08-17 20:58
 * @Updated-By: alton_z
 * @Update-Location:
 * 时间复杂度和空间复杂度和方法一在算法中可以看成是一致的，都是 O(N)
 * 但递归不需要用 queue 来进行辅助完成整个过程
 */
public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 确保每次 while 循环时，下面计算的节点都是在同一层的
            // 最后一次 while 循环就意味着时最深层的
            sum = 0;

            // 只遍历当前层节点，关键变量就是通过 size 进行控制
            int size = queue.size();

            // 遍历同一层的所有 Tree 节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return sum;

    }
}
