package java00274.m05;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {

        int len = citations.length;
        int left = 1, right = citations.length + 1;

        Arrays.sort(citations);

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (citations[len - mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;

    }
}