package java00671.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/7/27 8:14 上午
 * @Description:
 * 671. Second Minimum Node In a Binary Tree #244
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 *
 *
 * Input: root = [2,2,2]
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 25].
 * 1 <= Node.val <= 2^31 - 1
 * root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java00000.TreeNode;

import java.util.Stack;

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
 * inorder + recursion
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
 * Memory Usage: 36.6 MB, less than 31.30% of Java online submissions for Second Minimum Node In a Binary Tree.
 */
class Solution {

    public int findSecondMinimumValue(TreeNode root) {

        /**
         * 根据题意： 一个节点的根是其所有子节点的最小值
         * 因此根节点是二叉树中的最小值
         */
        int res = -1, minValue = root.val;

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
             *  将 cur 根据规则更新 res
             *  cur 值已经使用完，left 为空， cur = cur.right
             *  进入下一轮迭代
             *  1）cur.right 为空， 出栈（1）
             *  2）cur.right 不为空，进入下一轮入栈，再出栈
             */
            cur = help.pop();
            // 不为空时
            if (cur.val > minValue) {
                // res 还未赋值，直接赋值为 cur.val
                // 已赋值，取最小值
                res = res == -1 ? cur.val : Math.min(res, cur.val);
            }

            cur = cur.right;

        }

        return res;
    }
}
