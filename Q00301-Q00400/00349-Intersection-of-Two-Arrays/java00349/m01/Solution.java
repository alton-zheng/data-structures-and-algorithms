package java00349.m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/8/26 8:41 下午
 * @Description:
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0, second = 0;
        int l1 = nums1.length, l2 = nums2.length;

        List<Integer> res = new ArrayList<>();

        while (first < l1 && second < l2) {

            while (first + 1 < l1 && nums1[first] == nums1[first + 1]) {
                first++;
            }

            while (second + 1 < l2 && nums2[second] == nums2[second + 1]) {
                second++;
            }


            if (nums1[first] == nums2[second]) {
                res.add(nums1[first]);
            }

            if (nums1[first] < nums2[second]) {
                first++;
            } else {
                second++;
            }
        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
