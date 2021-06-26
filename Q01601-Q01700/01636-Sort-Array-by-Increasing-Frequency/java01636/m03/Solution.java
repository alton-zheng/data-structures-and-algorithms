package java01636.m03;

import java.util.Arrays;
import java.util.Comparator;

// Runtime: 8 ms, faster than 33.31% of Java online submissions for Sort Array by Increasing Frequency.
//Memory Usage: 39 MB, less than 70.13% of Java online submissions for Sort Array by Increasing Frequency.
class Solution {
    public int[] frequencySort(int[] nums) {

        // 题目中限制了 -100 <= nums[i] <= 100，所以可能取值范围是 [-100, 100]
        int[] help = new int[201];

        // 由于数组索引不能为负数，首先遍历数组将元素放入 help 索引范围 [1, 200] 中
        // 并且将每个元素出现的频次存入到数组中
        for (int item : nums){
            help[item + 100]++;
        }

        // 按题意排序
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> help[a + 100] != help[b + 100] ? help[a + 100] - help[b + 100] : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
}