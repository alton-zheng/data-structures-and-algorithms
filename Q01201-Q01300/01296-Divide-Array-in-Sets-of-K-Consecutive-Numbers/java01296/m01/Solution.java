package java01296.m01;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 6/20/21 9:17 AM
 * @Description:
 *
 * 1296. Divide Array in Sets of K Consecutive Numbers #131
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if it is possible. Otherwise, return False.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * Example 3:
 *
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * Example 4:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 *
 * Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
 *
 * Time Complexity : O()
 * Space Complexity : O()
 *
 *  Time Limit Exceeded
 */
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        if (nums.length % k != 0) {
            return false;
        }

        PriorityQueue<Integer> help = new PriorityQueue<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            help.add(nums[i]);
        }


        int time = nums.length / k;

        while (time > 0 && help.size() > 0) {

            int pre = queue.size() > 0 ? queue.poll() : help.poll();
            int num = k - 1;
            while (num > 0 && help.size() > 0) {
                int cur = help.poll();
                if (cur == pre + 1) {
                    num--;
                    pre = cur;
                    if (num == 0) {
                        time--;
                        break;
                    }
                } else {
                    queue.add(cur);
                    if (help.size() == 0) {

                        if (queue.size() == 1 && queue.peek() != pre + 1) {
                            break;
                        }

                        if (queue.peek() == pre + 1 ||  queue.peek() == pre) {
                            int len = queue.size();
                            while (len-- > 0) {
                                help.add(queue.poll());
                            }
                        }
                    }
                }
            }

        }

        if (time == 0) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleDivide(new int[]{1,1,2,2,3,3}, 2));    }
}
