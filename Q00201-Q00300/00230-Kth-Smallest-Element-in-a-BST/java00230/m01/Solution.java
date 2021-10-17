package java00230.m01;


import java00000.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: alton
 * @Date: Created in 6/12/21 10:33 AM
 * @Description: 230. Kth Smallest Element in a BST #101
 * <p>
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 * <p>
 * Time Complexity: O()
 * Space Complexity: O()
 * /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
 * Memory Usage: 39.7 MB, less than 20.41% of Java online submissions for Kth Smallest Element in a BST.
 *
 * Time Complexity: O(N + H)
 * Space Complexity: O(N + H)
 */
class Solution {

    public int kthSmallest(TreeNode root, int k) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}

