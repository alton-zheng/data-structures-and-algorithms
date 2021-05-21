package java01035;

/**
 * @Author: alton
 * @Date: Created in 5/21/21 3:28 PM
 * @Description:
 * 1035. Uncrossed Lines #26
 * We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 *
 * nums1[i] == nums2[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,4,2], nums2 = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from nums1[1]=4 to nums2[2]=4 will intersect the line from nums1[2]=2 to nums2[1]=2.
 * Example 2:
 *
 * Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * Output: 2
 *
 *
 * Note:
 *
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 */

/**
 * 解读题，可以知道它其实求解的是两个数组的最长公共子序列
 * 而两个数组的公共子序列，其实就是典型的二维动态规划问题
 * Time Complexity: O(nums1Len * nums2Len)
 * Space Complexity: O(nums1Len * nums2Len)
 */
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int nums1Len = nums1.length, nums2Len = nums2.length;

        int[][] help = new int[nums1Len + 1][nums2Len + 1];

        for (int i = 1; i <= nums1Len; i++) {
            for (int j = 1; j <= nums2Len; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    help[i][j] = help[i - 1][j - 1] + 1;
                } else {
                    help[i][j] = Math.max(help[i][j - 1], help[i - 1][j]);
                }
            }
        }

        return help[nums1Len][nums2Len];

    }
}
