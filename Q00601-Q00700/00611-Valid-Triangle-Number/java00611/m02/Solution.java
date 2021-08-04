package java00611.m02;

import java.util.Arrays;

/**
 * Runtime: 37 ms, faster than 57.78% of Java online submissions for Valid Triangle Number.
 * Memory Usage: 38.6 MB, less than 69.39% of Java online submissions for Valid Triangle Number.
 *
 * Time Complexity: O(N^2 + N)
 * Space Complexity: O(logN)
 */
class Solution {
    public int triangleNumber(int[] nums) {
        
        int len = nums.length;
        
        Arrays.sort(nums);
        
        int res = 0;
        
        for (int i = 0; i < len; i++) {
            int k = i;
            
            for (int j = i + 1; j < len; j++) {
                while (k + 1 < len && nums[i] + nums[j] > nums[k + 1]) {
                    k++;
                }
                
                res += Math.max(k - j, 0);
            }
        }
        
        return res;
    }
}