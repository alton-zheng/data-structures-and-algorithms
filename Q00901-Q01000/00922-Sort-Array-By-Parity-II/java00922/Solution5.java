package java00922;

/**
 * @Author: alton
 * @Date: Created in 5/26/21 1:59 PM
 * @Description:
 * 922. Sort Array By Parity II #45
 *
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Example 2:
 *
 * Input: nums = [2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 104
 * nums.length is even.
 * Half of the integers in nums are even.
 * 0 <= nums[i] <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2 ms, faster than 98.71% of Java online submissions for Sort Array By Parity II.
 * Memory Usage: 41.8 MB, less than 28.21% of Java online submissions for Sort Array By Parity II.
 */
class Solution5 {
    public int[] sortArrayByParityII(int[] nums) {

        int[] res = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[even] = nums[i];
                even += 2;
            } else {
                res[odd] = nums[i];
                odd += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        new Solution5().sortArrayByParityII(nums);
    }
}
