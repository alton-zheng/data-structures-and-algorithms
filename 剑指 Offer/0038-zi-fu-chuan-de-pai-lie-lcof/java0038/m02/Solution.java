package java0038.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/22/21 8:59 PM
 * @Description:
 *
 * 执行用时： 7 ms, 在所有 Java 提交中击败了98.80%的用户
 * 内存消耗： 42.7 MB, 在所有 Java 提交中击败了80.14%的用户
 */
class Solution {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        do {
            res.add(new String(arr));
        } while (nextPermutation(arr));
        int size = res.size();
        String[] retArr = new String[size];
        for (int i = 0; i < size; i++) {
            retArr[i] = res.get(i);
        }
        return retArr;
    }

    private boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}