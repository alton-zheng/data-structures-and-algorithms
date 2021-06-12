package java00230;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/12/21 10:33 AM
 * @Description:
 *
 * 230. Kth Smallest Element in a BST #101
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
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * dfs inorder
 */
class Solution2 {

    int kth = -1;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        inorder(root);

    }

    private void inorder(TreeNode node) {

        if (node == null || kth < 0) {
            return;
        }

        inorder(node.left);

        if (--kth == 0) {
            res = node.val;
        }
        inorder(node.right);

    }
}
