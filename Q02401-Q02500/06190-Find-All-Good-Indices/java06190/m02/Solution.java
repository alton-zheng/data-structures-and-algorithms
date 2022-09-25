package java06190.m02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-25 13:24
 * @Update Date Time: 2022-09-25 13:24
 * @Updated-By: alton_z
 * @Update-Location:
 */

/**
 * 此题有坑， 非递增需要理解为前 k 个元素相邻元素不能有递增
 *          非递减需要理解为后 k 个元素相邻元素不能有递减
 *
 * 维护 f[i] 表示以第 ii 个下标为结尾的非递增连续子数组最长是多少，
 * g[i] 表示以第 ii 个下标为开头的非递减连续子数组最长是多少。
 * 好下标即为满足 f[i - 1] >= k && g[i + 1] >= k 的下标。
 * 复杂度 $O(n)$
 *
 *
 */
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {

        int len = nums.length;
        int[] f = new int[len];
        f[0] = 1;
        for (int i = 1; i < len; i++) {
            f[i] = nums[i] <= nums[i - 1] ? f[i - 1] + 1 : 1;
        }

        int[] g = new int[len];
        g[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            g[i] = nums[i + 1] >= nums[i] ? g[i + 1] + 1 : 1;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = k; i < len - k; i++)
        {
            if (f[i - 1] >= k && g[i + 1] >= k) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int a : new Solution().goodIndices(new int[]{2,1,1,1,3,4,1}, 2)) {
            System.out.println(a);
        }
    }
}
