package java00654.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-20 08:39
 * @Update Date Time: 2022-08-20 08:39
 * @Updated-By: alton_z
 * @Update-Location:
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 进入递归， 全数组
        return MBT(nums, 0, nums.length - 1);
    }

    private TreeNode MBT(int[] nums, int l, int r) {

        // 边界场景
        if (l > r) {
            return null;
        }

        // 定义最大值 index 变量, 初始化为一个值，这里选择 l
        // 它必须是数组 [l,r]
        int mVIndex = l;

        for (int i = l + 1; i <= r; i++) {

            // 找到 nums,  [l, r]  范围内最大值所在 index , 作为 mVIndex
            if (nums[i] > nums[mVIndex]) {
                mVIndex = i;
            }
        }

        // 返回当前范围 root 为 nums[mVIndex] 的树
        return new TreeNode(
                nums[mVIndex],
                MBT(nums, l, mVIndex - 1),
                MBT(nums, mVIndex + 1, r)
        );

    }
}
