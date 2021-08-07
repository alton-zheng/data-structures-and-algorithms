package java00457.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/7 4:12 下午
 * @Description:
 * 457. Circular Array Loop
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Circular Array Loop.
 * Memory Usage: 36.4 MB, less than 65.34% of Java online submissions for Circular Array Loop.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {

    public boolean circularArrayLoop(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            // 也可以写成 !nums[i]
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = next(nums, len, i);

            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, len, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, len, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }

                slow = next(nums, len, slow);
                fast = next(nums, len, next(nums, len, fast));
            }

            int u = i;

            while (nums[u] * nums[next(nums, len, u)] > 0) {
                int temp = u;
                u = next(nums, len, u);
                nums[temp] = 0;
            }
        }

        return false;

    }

    private int next(int[] nums, int len, int idx) {
        return ((idx + nums[idx]) % len + len) % len;
    }
}
