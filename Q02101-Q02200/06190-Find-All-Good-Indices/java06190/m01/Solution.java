package java06190.m01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-25 13:15
 * @Update Date Time: 2022-09-25 13:15
 * @Updated-By: alton_z
 * @Update-Location:
 */
/**
 * 此题有坑， 非递增需要理解为前 k 个元素相邻元素不能有递增
 *          非递减需要理解为后 k 个元素相邻元素不能有递减
 *
 */
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {

        int len = nums.length;

        int minIndex = k, maxIndex = len - k - 1;

        List<Integer> res = new ArrayList<>();
        if (k == 1) {
            for (int i = minIndex; i <= maxIndex; i++) {
                res.add(i);
            }

            return res;
        }

        int resLen = len - 2*k;

        int[] first = new int[resLen];
        int firstIndex = 0;
        for (int i = 0; i < resLen; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > temp) {
                    first[firstIndex] = -1;
                    break;
                }
                temp = nums[j];
            }

            firstIndex++;
        }

        int[] second = new int[resLen];
        int secondIndex = 0;
        for (int i = k + 1; i < k + 1 + resLen; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] < temp) {
                    second[secondIndex] = -1;
                    break;
                }

                temp = nums[j];
            }

            secondIndex++;
        }


        int index = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (first[index] != -1 && second[index] != -1) {
                res.add(i);
            }
            index++;
        }

        return res;

    }

    public static void main(String[] args) {
        for (int a : new Solution().goodIndices(new int[]{2,1,1,1,3,4,1}, 2)) {
            System.out.println(a);
        }
    }
}
