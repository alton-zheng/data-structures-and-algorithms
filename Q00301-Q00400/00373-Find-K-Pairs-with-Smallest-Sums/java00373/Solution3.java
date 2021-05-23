package java00373;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 10:28 AM
 * @Description:
 * 373. Find K Pairs with Smallest Sums #34
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 and nums2 both are sorted in ascending order.
 * 1 <= k <= 1000h
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * 递归算法（利用快排优化排序算法），但会栈溢出
 */
class Solution3 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        int n = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> help = new ArrayList<>();
                help.add(nums1[i]);
                help.add(nums2[j]);
                res.add(help);
            }
        }

        return getKSmallestPairs(res, 0, res.size() - 1, res.size() < k ? res.size() - 1 : k - 1);

    }

    private List<List<Integer>> getKSmallestPairs(List<List<Integer>> res, int start, int end, int kSmallIndex) {
        int compare =  quick(res, start, end);

        if (compare == kSmallIndex) {
            return res.subList(0, kSmallIndex);
        }


        return compare > kSmallIndex
                ? getKSmallestPairs(res, start, compare - 1, kSmallIndex)
                : getKSmallestPairs(res, compare + 1, end, kSmallIndex);

    }

    private int quick(List<List<Integer>> res, int start, int end) {
        int compare = res.get(start).get(0) + res.get(start).get(1);
        int i = start, j = end + 1;

        while (true) {
            while (++i <= end && (res.get(i).get(0) + res.get(i).get(1)) <= compare);
            while (--j >= start && (res.get(j).get(0) + res.get(j).get(1) > compare));

            if (i >= j) {
                break;
            }

            List<Integer> help;
            help = res.get(i);

            res.set(i, res.get(j));
            res.set(j, help);
        }

        List<Integer> swap;
        swap = res.get(start);
        res.set(start, res.get(j));
        res.set(j, swap);

        return j;

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums1 = new int[]{-1,-1,-1,-1,-1};
        int[] nums2 = new int[]{-1,-1,-1,-1,-1};
        System.out.println(new Solution3().kSmallestPairs(nums1, nums2, 100));
    }
}
