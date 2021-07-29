package java00563.m01;

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
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Tilt.
 * Memory Usage: 38.7 MB, less than 91.42% of Java online submissions for Binary Tree Tilt.
 */

import java00000.TreeNode;
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
 */
class Solution {

    // 定义坡度总值 -> 结果值
    private int res = 0;
    public int findTilt(TreeNode root) {

        //dfs + 后续遍历递归
        LRM(root);

        // 返回坡度和
        return res;
    }

    private int LRM(TreeNode node) {

        // 空节点的节点值默认为 0，题目中也有相关介绍，这里不再赘述
        if (node == null) {
            return 0;
        }

        // 递归求当前节点 left 树的节点和
        int l = LRM(node.left);

        // 递归求当前节点的 right 树的节点和
        int r = LRM(node.right);

        // 算坡度，并将每个节点的坡度添加到结果 res 中
        res += Math.abs(l - r);

        // 返回当前节点的节点和
        // 对于 root 来说， 其节点和是无意义的，它不再有父节点来用节点和算坡度了
        return l + r + node.val;

    }
}
