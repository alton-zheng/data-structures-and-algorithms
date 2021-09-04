package java1714.m01;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: alton
 * @Date: Created in 2021/9/3 3:33 下午
 * @Description:
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 执行结果： 通过 显示详情 添加备注
 * 执行用时： 28 ms , 在所有 C++ 提交中击败了 75.83% 的用户
 * 内存消耗： 17.7 MB , 在所有 C++ 提交中击败了 71.41% 的用户
 * 通过测试用例： 29 / 29
 *
 */
public class Solution {

    public int[] smallestK(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {

            return new int[]{};
        }

        // 直接用 Java Arrays 类
       /* Arrays.sort(arr);
        int[] result = Arrays.copyOf(arr, k);
        return result;*/


        // 自己实现部分逻辑
        /*Arrays.sort(arr);

        int length = Math.min(k, arr.length);
        int[] result = new int[length];

        for(int i = 0; i < length; i++) {
            result[i] = arr[i];
        }

        return result;*/

        // 自己用快排实现，比 java 自带的排序性能优越
        return quickOrder(arr, 0, arr.length - 1, k - 1);

    }

    private int[] quickOrder(int[] arr, int startIndex, int endIndex, int leastNumberArrayMaxIndex) {

        int quickIndex = quickPartition(arr, startIndex, endIndex);

        if (quickIndex == leastNumberArrayMaxIndex) {
            int min = Math.min(leastNumberArrayMaxIndex + 1, arr.length);
            int[] result = new int[min];

            for (int i = 0; i < min; i++) {
                result[i] = arr[i];
            }

            return result;
        }

        return quickIndex > leastNumberArrayMaxIndex
                ? quickOrder(arr, startIndex, quickIndex - 1, leastNumberArrayMaxIndex)
                : quickOrder(arr, quickIndex + 1, endIndex, leastNumberArrayMaxIndex);

    }

    private int quickPartition(int[] arr, int startIndex, int endIndex) {

        int compareValue = arr[startIndex];
        int i = startIndex, j = endIndex + 1;

        while (true) {
            while (++i <= endIndex && arr[i] < compareValue);
            while (--j >= startIndex && arr[j] > compareValue);

            if (i >= j) {
                break;
            }

            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;

        }

        arr[startIndex] = arr[j];
        arr[j] = compareValue;

        return j;
    }
}
