package java0094.m02;

import java00000.TreeNode;

import java.util.*;

/**
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
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 37 MB, less than 88.31% of Java online submissions for Binary Tree Inorder Traversal.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        // 定义结果集 list
        List<Integer> res = new ArrayList<>();

        /**
         * MLR :
         *      压栈顺序：right -> root -> left
         *      出栈顺序：left -> root -> right
         */
        Stack<TreeNode> help = new Stack<>();

        /**
         * 为了更好地理解这种方法，这里不采用更抽象的方法来写代码
         * 采用通俗易懂的方式来解读
         */
        // 首先将 root 压栈（属于第一轮压栈）
        help.push(root);

        // 中序遍历，首先遍历 left， 定义当前节点为 root.left
        TreeNode cur = root.left;

        // 整棵树迭代完后，结束
        // 当前节点不为空或栈不为空时才进行压栈或入栈行为
        while (cur != null || !help.isEmpty()) {

            // 首次迭代，开启第 1 轮压栈，与视频中对应
            // 第 2 -> N 时， cur 不为空，也就是上一轮 的 cur.right 右子树不为空时，开启压栈
            // cur -> left 入栈
            while (cur != null) {
                help.push(cur);
                cur = cur.left;
            }

            /**
             *  第 N 轮压栈完成后，cur 当前节点为空，这里是关键点
             *  1. 将栈顶节点出栈(cur 父节点)， 赋值给 cur, cur = help.pop() （此节点 left 为空）
             *  将 cur 节点的值添加到结果集中
             *  cur 值已经使用完，left 为空， cur = cur.right
             *  进入下一轮迭代
             *  1）cur.right 为空， 出栈（1）
             *  2）cur.right 不为空，进入下一轮入栈，再出栈
             */
            cur = help.pop();
            res.add(cur.val);
            cur = cur.right;

        }

        return res;
    }
}