package java00001;

import java.util.Arrays;

class Solution {
    
    public void quickSort(int[] nums) {
       
        if (nums == null || nums.length < 2) {
            return;
        }
        
        // 开始快排 
        quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int left, int right) {
        
        // 定义边界场景, left 大于小于 right, 直接返回，不处理
        if (left >= right) {
            return;
        }
        
        // left 位置值作为比较对象
        int compareValue = nums[left];
        
        // 初始化 i, j 指针
        // i 为 left, j 为 right + 1
        int i = left, j = right + 1;

        // 开始按照快排规则进行 swap
        while (true) {
            while (++i <= right && nums[i] < compareValue);
            while (--j >= left && nums[j] > compareValue);

            if (i >= j) {
                break;
            }

            // 将数组值互换，调整
            swap(nums, i, j);

        }

        // 将 j 位置值放 left 位置上
        nums[left] = nums[j];
        
        // j 位置放比较值， 执行到这， j 位置的值固定
        nums[j] = compareValue;
        
        // 左边比 j 位置小的值再进行快排
        quickSort(nums, left, j - 1);
        
        // 右边比 j 位置大的值再进行快排
        quickSort(nums, j + 1, right);
        
    }
    
    private void swap(int[] nums, int i, int j) {
        
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        
    }
    
}