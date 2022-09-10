package java00669.m02;

import java00000.TreeNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-10 17:11
 * @Update Date Time: 2022-09-10 17:11
 * @Updated-By: alton_z
 * @Update-Location:
 */
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
    public TreeNode trimBST(TreeNode root, int low, int high) {


        while (root != null) {

            if (root.val > high) {
                root = root.left;
            } else if (root.val < low) {
                root = root.right;
            } else {
                break;
            }
        }

        if (root == null) {
            return null;
        }

        TreeNode temp = root;
        while (temp.left != null) {
            if (temp.left.val < low) {
                temp.left = temp.left.right;
            } else {
                temp = temp.left;
            }
        }

        temp = root;
        while (temp.right != null) {
            if (temp.right.val > high) {
                temp.right = temp.right.left;
            } else {
                temp = temp.right;
            }
        }

        return root;

    }
}