package java00752.m01;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/25/21 8:33 AM
 * @Description:
 *
 * 752. Open the Lock #145
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 *
 *
 * Example 1:
 *
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 *
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 *
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 *
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 *
 * Time Complexity : O(b^d*d^2 + md)
 * Space Complexity : O(b^d*d + m)
 *
 * Runtime: 67 ms, faster than 83.00% of Java online submissions for Open the Lock.
 * Memory Usage: 42.7 MB, less than 86.66% of Java online submissions for Open the Lock.
 *
 */
class Solution {

    public int openLock(String[] deadends, String target) {

        String ZERO = "0000";

        if (ZERO.equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>();

        for (String d: deadends) {
            dead.add(d);
        }

        if (dead.contains(ZERO)) {
            return -1;
        }

        int res = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(ZERO);

        Set<String> seam = new HashSet<>();
        seam.add(ZERO);

        while (!queue.isEmpty()) {
            res++;

            int len = queue.size();
            for (int i = 0; i < len; i++) {

                for (String nextStatus : getList(queue.poll())) {

                    if (!seam.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (target.equals(nextStatus)) {
                            return res;
                        }

                        seam.add(nextStatus);
                        queue.offer(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getList(String lock) {

        List<String> ret = new ArrayList<>();
        char[] cur = lock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = cur[i];
            cur[i] = pre(tmp);
            ret.add(new String(cur));
            cur[i] = next(tmp);
            ret.add(new String(cur));
            cur[i] = tmp;
        }
        return ret;
    }

    private char pre(char c) {
        return c == '0' ? '9' : (char)(c - 1);
    }

    private char next(char c) {
        return c == '9' ? '0' : (char)(c + 1);
    }
}
