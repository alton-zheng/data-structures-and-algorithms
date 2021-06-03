package java00215;

import com.sun.media.sound.SF2InstrumentRegion;

import java.util.Random;

/**
 * @Author: alton
 * @Date: Created in 6/3/21 3:34 PM
 * @Description:
 * 215. Kth Largest Element in an Array #71
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
 *
 * Runtime: 1 ms, faster than 97.76% of Java online submissions for Kth Largest Element in an Array.
 * Memory Usage: 41.6 MB, less than 5.32% of Java online submissions for Kth Largest Element in an Array.
 * random for quick order
 *
 *
 */
class Solution {
    private Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return getKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int getKthLargest(int[] nums, int startIndex, int endIndex, int target) {

        int temp = random.nextInt(endIndex - startIndex + 1) + startIndex;
        swap(nums, temp, startIndex);
        int curIndex = quickOrder(nums, startIndex, endIndex);

        if (curIndex == target) {
            return nums[curIndex];
        }

        return curIndex < target
                ? getKthLargest(nums, curIndex + 1, endIndex, target)
                : getKthLargest(nums, startIndex, curIndex - 1, target);

    }

    private int quickOrder(int[] nums, int startIndex, int endIndex) {
        int compare = nums[startIndex];
        int i = startIndex, j = endIndex + 1;

        while (true) {
            while (++i <= endIndex && nums[i] > compare);
            while (--j >= startIndex && nums[j] < compare);

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }

        swap(nums, startIndex, j);
        return j;
    }

    private void swap(int[] nums, int first, int second) {
        int swap = nums[first];
        nums[first] = nums[second];
        nums[second] = swap;
    }
}

