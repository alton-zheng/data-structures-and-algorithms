package java00108.m01;

/**
 * @Author: alton
 * @Date: Created in 7/7/21 9:37 PM
 * @Description:
 *
 * 108. Convert Sorted Array to Binary Search Tree #184
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 * Time Complexity : O()
 * Space Complexity : O()
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
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 * Memory Usage: 38.8 MB, less than 50.45% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length - 1);
    }

    public TreeNode inorder(int[] nums, int left, int right) {

        // 当 left > right 时，当前树完成
        if (left > right) {
            return null;
        }

        // 选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorder(nums, left, mid - 1);
        root.right = inorder(nums, mid + 1, right);
        return root;
    }
}
