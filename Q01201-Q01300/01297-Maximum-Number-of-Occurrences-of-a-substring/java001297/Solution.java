package java001297;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/11/21 5:30 PM
 * @Description:
 *
 * Runtime: 53 ms, faster than 41.14% of Java online submissions for Maximum Number of Occurrences of a Substring.
 * Memory Usage: 40.8 MB, less than 88.23% of Java online submissions for Maximum Number of Occurrences of a Substring.
 */
public class Solution {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int mod = 1000000007;

        int sLen = s.length();
        Map<Integer, Integer> help = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();

        int sCount = 0, res = 0;
        int rabin = 0, base = 26, base_mul = base;

        for (int i = 0; i < sLen; i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);

            if (count.get(s.charAt(i)) == 1) {
                sCount++;
            }

            rabin = (rabin * base + (s.charAt(i) - 97)) % mod;

            if (i < minSize - 1) {
                base_mul = (base_mul * base) % mod;
            }

            if (i >= minSize) {
                count.put(s.charAt(i - minSize), count.get(s.charAt(i - minSize)) - 1);
                if (count.get(s.charAt(i - minSize)) == 0) {
                    sCount--;
                }

                rabin = (rabin - base_mul * (s.charAt(i - minSize) - 97) % mod + mod) % mod;
            }

            if (i >= minSize - 1 && sCount <= maxLetters) {
                help.put(rabin, help.getOrDefault(rabin, 0) + 1);
                res = Math.max(res, help.get(rabin));
            }
        }

        return res;
    }
}
