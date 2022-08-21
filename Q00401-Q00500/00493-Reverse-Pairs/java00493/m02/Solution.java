package java00493.m02;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-21 19:30
 * @Update Date Time: 2022-08-21 19:30
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class Solution {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        // left < right
        int mid = left + ((right - left) >> 1);
        return process(nums, left, mid) + process(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        // [left....M] [M+1....R]
        // 下面这部分代码是此题的求数的代码
        // 定义结果值
        int res = 0;
        // 目前囊括进来的数，是从[M+1, r)
        // 定义当前 right 位置，初始化为 mid + 1
        int r = mid + 1;

        // 下面代码是此算法核心
        //
        for (int i = left; i <= mid; i++) {
            while (r <= right && (long) nums[i] > (long) nums[r] * 2) {
                r++;
            }
            res += r - mid - 1;
        }

        // 下面的代码就是普通的归并排序代码
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= right) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
        return res;
    }

}
