package java00004.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-10 22:58
 * @Update Date Time: 2022-08-10 22:58
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 4. Median of Two Sorted Arrays #424
 *
 */
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         * 思路：
         * 1. 首先求出两个数组长度
         * 2. 因数组已排序，先求出两个数组中间数值的索引值（综合）
         *  1）偶数，则 first 和 second 索引位置不同
         *  2）奇数，则 位置相同
         * 3.分别寻找 first, second 所在位置的元素值
         * 4.求两个值的平均值
         */
        int i1Length = nums1.length;
        int i2Length = nums2.length;

        int first = (i1Length + i2Length + 1) / 2;
        int second = (i1Length + i2Length + 2) / 2;

        return (findValue(nums1, 0, nums2, 0, first)
                + findValue(nums1, 0, nums2, 0, second))
                / 2.0;

    }

    /**
     * @param nums1                 第一个数组
     * @param firstArrayStartIndex  第一个数组开始索引位置
     * @param nums2                 第二个数组
     * @param secondArrayStartIndex 第二个数组开始索引位置
     * @param valueIndex            寻找的两个数组综合索引位置
     * @return 返回 valueIndex 位置所在的元素值
     * 由于需要满足时间复杂度，因此这里使用二分查找算法来处理
     */
    private static int findValue(int[] nums1, int firstArrayStartIndex, int[] nums2, int secondArrayStartIndex, int valueIndex) {

        // 直到以下 3 个场景之一被处罚，查找操作才结束。

        // 边界场景1： 当第一个数组开始搜索索引位置已经越界，说明目标在第二个数组里，返回第二个数组对应索引位置
        if (firstArrayStartIndex >= nums1.length) {
            return nums2[secondArrayStartIndex + valueIndex - 1];
        }

        // 边界场景2： 当第二个数组开始搜索索引位置已经越界，说明目标在第一个数组里，返回第一个数组对应索引位置
        if (secondArrayStartIndex >= nums2.length) {
            return nums1[firstArrayStartIndex + valueIndex - 1];
        }

        // 边界场景3： 如果需要定位目标索引值为1，比较两个数组开始索引位置，取 min 值
        if (valueIndex == 1) {
            return Math.min(nums1[firstArrayStartIndex], nums2[secondArrayStartIndex]);
        }

        // 第一个数组，索引位置往后移动 valueIndex/2
        int firstHalf = firstArrayStartIndex + valueIndex / 2;

        // 第二个数组，索引位置往后移动 valueIndex/2
        int secondHalf = secondArrayStartIndex + valueIndex / 2;

        // 第一个数组待判断的索引位置
        int firstTemp = firstHalf - 1;

        // 第二个数组待判断的索引位置
        int secondTemp = secondHalf - 1;

        // 利用二分查找算法来对 midVal1, midVal2 进行取值
        // 当待处理索引位置还是数组范围内， 取相对应的值作为比较值
        // 如超出数组范围，意味着数组值被淘汰，则取 Integer.MAX_VALUE 作为取值
        int midVal1 = firstTemp < nums1.length ? nums1[firstTemp] : Integer.MAX_VALUE;
        int midVal2 = secondTemp < nums2.length ? nums2[secondTemp] : Integer.MAX_VALUE;

        int nextValueIndex = valueIndex - valueIndex / 2;
        // 比较两个数组，相对于开始索引位置，对应 valueIndex/2 位置的值， 根据比较结果，排除数值，并且查找位置自减一半，再次进去循环
        if (midVal1 < midVal2) {
            // midVal1 小， 说明需要找的数值
            // 不会在第一个数组的相对于 [firstArrayStartIndex, firstArrayStartIndex + valueIndex/2] 范围内
            // 将其排除到查找范围内
            // 再次进入循环
            return findValue(nums1, firstHalf, nums2, secondArrayStartIndex, nextValueIndex);
        } else {
            // 相反，排除第二个数组对应位置，进入下一次查找
            return findValue(nums1, firstArrayStartIndex, nums2, secondHalf, nextValueIndex);
        }
    }

}
