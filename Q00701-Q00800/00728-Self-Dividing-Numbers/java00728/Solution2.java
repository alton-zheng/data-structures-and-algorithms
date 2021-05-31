package java00728;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/31/21 3:47 PM
 * @Description:
 *
 * 728. Self Dividing Numbers #61
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 *
 * Time Complexity: O(right - left + 1)
 * Space Complexity : O(right - left + 1)
 */
class Solution2 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (isDividingNumber(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isDividingNumber(int i) {

        int d = i;
        while (d > 0) {
            int temp = d % 10;
            if (temp % 10 == 0 || i % temp != 0) {
                return false;
            }
            d /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution2().selfDividingNumbers(1, 10);
    }
}
