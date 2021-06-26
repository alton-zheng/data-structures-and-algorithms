package java00172.m02;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 2:19 PM
 * @Description:
 *
 * Runtime: 4 ms, faster than 13.33% of Java online submissions for Factorial Trailing Zeroes.
 * Memory Usage: 35.8 MB, less than 70.05% of Java online submissions for Factorial Trailing Zeroes.
 */
import java.math.BigInteger;

class Solution {
    public int trailingZeroes(int n) {

        int res = 0;

        for (int i = 5; i < n + 1; i += 5) {
            int temp = i;
            while (temp % 5 == 0) {
                res++;
                temp /= 5;
            }
        }

        return res;
    }
}
