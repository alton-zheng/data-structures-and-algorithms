package java00477;

/**
 * @Author: alton
 * @Date: Created in 5/28/21 8:51 AM
 * @Description:
 * 477. Total Hamming Distance #50
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,14,2]
 * Output: 6
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case).
 * The answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Example 2:
 *
 * Input: nums = [4,14,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 *
 * Time Complexity: O(N^N)
 * Space Complexity: O(1)
 * Time Limit Exceeded
 */
class Solution2 {
    public int totalHammingDistance(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int orResult = nums[i] ^ nums[j];
                while (orResult != 0) {
                    res++;
                    orResult &= orResult - 1;
                }
            }
        }

        return res;
    }
}

