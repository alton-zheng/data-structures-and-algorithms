import java.math.BigInteger;

/**
 * @Author: alton
 * @Date: Created in 4/30/21 9:37 PM
 * @Description:
 */
public class Solution {

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
     *
     * F(0) = 0, F(1) = 1
     * F(n) = F(n - 1) + F(n - 2), for n > 1.
     * Given n, calculate F(n).
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 1
     * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     * Example 2:
     *
     * Input: n = 3
     * Output: 2
     * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     * Example 3:
     *
     * Input: n = 4
     * Output: 3
     * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     *
     *
     * Constraints:
     *
     * 0 <= n <= 30
     * * 思路： 递归实现，由于 int n 在 0 <= n <= 100 范围内，此算法会溢出，因此用BigInteger 来替代
     * * 1. 构建递归函数，
     * *  第1个参数： 为 f(n - 2) 的值
     * *  第2个参数： 为 f(n - 1) 的值
     * *  第3个参数： 为 当前 n 值
     * * 2. 当 n 递归为 1 后，返回结果，当然 n 开始时，等于 0, 1 就不会递归，直接返回数据
     * * 注意： 由于 n 不会大于100， 不会造成栈溢出，如果 n 过大，可考虑 while 循环 或 优化递归程序，使用函数式编程
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {

        return fib_(BigInteger.ONE, BigInteger.ZERO, n).mod(new BigInteger("100000007")).intValue();

    }

    private static BigInteger fib_(BigInteger acc1, BigInteger acc2, int x) {
        if (x == 0) {
            return BigInteger.ZERO;
        } else if (x == 1) {
            return acc1.add(acc2);
        } else {
            return fib_(acc2, acc1.add(acc2), x - 1);
        }
    }

    /**
     * for 循环方式
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int result = 0;
        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            result = first + second;
            if (result > 1e7) {
                result -= 1e7;
            }
            first = second;
            second = result;
        }

        return result;
    }

}
