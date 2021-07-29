package java00563.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/7/29 6:06 下午
 * @Description:
 * 563. Binary Tree Tilt #252
 *
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 *
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if there the node does not have a right child.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 1
 * Explanation:
 * Tilt of node 2 : |0-0| = 0 (no children)
 * Tilt of node 3 : |0-0| = 0 (no children)
 * Tilt of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
 * Sum of every tilt : 0 + 0 + 1 = 1
 * Example 2:
 *
 *
 * Input: root = [4,2,9,3,5,null,7]
 * Output: 15
 * Explanation:
 * Tilt of node 3 : |0-0| = 0 (no children)
 * Tilt of node 5 : |0-0| = 0 (no children)
 * Tilt of node 7 : |0-0| = 0 (no children)
 * Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
 * Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
 * Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
 * Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15
 * Example 3:
 *
 *
 * Input: root = [21,7,14,1,1,2,2,3,3]
 * Output: 9
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

import java00000.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
 * Runtime: 4 ms, faster than 15.68% of Java online submissions for Binary Tree Tilt.
 * Memory Usage: 39.3 MB, less than 41.73% of Java online submissions for Binary Tree Tilt.
 */
class Solution {

    public int findTilt(TreeNode root) {

        // 节点为空时，树坡度为 0
        if (root == null) {
            return 0;
        }

        // 定义迭代 stk
        Deque<TreeNode> stk = new LinkedList<>();

        // 记录整棵树入栈的顺序, 这里注意了
        LinkedList<TreeNode> trees = new LinkedList<>();

        // 先将 root 节点入栈
        stk.push(root);

        // 栈不为空，处理
        // 将整棵树所有节点按 left, right 的顺序入栈
        while (!stk.isEmpty()) {

            // 首先从栈中取出当前的树节点
            TreeNode treeNode = stk.pop();

            // 将从栈中取出的树节点，放入到 trees 中，
            // 后添加的放在首元素，后面的节点位置相应的后移
            trees.addFirst(treeNode);

            // 先将当前节点的子树 left -> right 入栈（后续迭代）
            // left 不为空才有意义
            if (treeNode.left != null) {
                // left 压栈
                stk.push(treeNode.left);
            }

            // right 不为空才有意义
            if (treeNode.right != null) {

                // right 入栈
                stk.push(treeNode.right);

            }
        }

        // 到这里为栈，栈功成身退，后面只需要处理每颗树的 val 即可， 从整棵树的底部到顶部依次进行处理

        // 定义总坡度变量,也就是结果
        int res = 0;
        // 遍历 trees ,这时候的 treeNode，
        for (TreeNode tree : trees) {
            // 当前树的 left 树的 val, 为空时，默认 0， 不为空时，取其值
            int left = tree.left == null ? 0 : tree.left.val;

            // 当前树的 right 树的 val，为空时，默认 0， 不为空，取其值
            int right = tree.right == null ? 0 : tree.right.val;

            // 将当前树的节点 val, 赋值为当前数所有节点和
            // 与递归方法中，LRM 方法返回值的用法一样的效果，没有区别，在 LRM 中也可以这样处理
            // 当这里不能根递归方法中处理一样返回，这里没有回调这些返回值的地方
            // 将节点值进行更新，称为后序遍历处理此问题的思路和方法
            tree.val = left + right + tree.val;

            // 回到题目，利用left, right 总值计算坡度值，并将当前树的坡度值添加到 res 中
            res += Math.abs(left - right);

        }

        // 返回结果值即可
        return res;
    }
}
