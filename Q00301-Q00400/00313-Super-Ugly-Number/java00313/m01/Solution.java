package java00313.m01;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 2021/8/9 10:56 上午
 * @Description:
 * 00313-Super-Ugly-Number
 *
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
 * Example 2:
 *
 * Input: n = 1, primes = [2,3,5]
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
 *
 *
 * Constraints:
 *
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * primes[i] is guaranteed to be a prime number.
 * All the values of primes are unique and sorted in ascending order.
 *
 * Time Complexity: O(nmlognm)
 * Space Complexity: O(nm)
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> help = new HashSet<>();
        queue.offer(1L);
        help.add(1L);

        for (int i = 1; i <= n; i++) {

            long item = queue.poll();

            if (i == n) {
                return (int)item;
            }

            for (int prime: primes) {
                long cur = item * prime;
                if (help.add(cur)) {
                    queue.offer(cur);
                }
            }
        }

        return 1;
    }
}
