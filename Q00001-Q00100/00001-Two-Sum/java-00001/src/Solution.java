import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 4/29/21 2:38 PM
 * @Description:
 */
public class Solution {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * e.g.
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * solution:
     *  补数方法：
     *  1. 循环数组
     *  2. 按数据循环存储元素对应补数和元素 index 到 map
     *  3. 一旦遇到数组中元素有等于补数的位置即可停止循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> kv = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];

            if (kv.containsKey(value)) {
                result[0] = kv.get(value);
                result[1] = i;
                return result;
            }

            kv.put(target - value, i);
        }

        return result;

    }

    private static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] source = {3,2,4};
        printArr(new Solution().twoSum(source, 6));
    }
}
