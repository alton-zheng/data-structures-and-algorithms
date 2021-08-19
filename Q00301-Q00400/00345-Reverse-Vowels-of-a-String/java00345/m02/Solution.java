package java00345.m02;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 2021/8/19 上午11:12
 * @Description:
 * 345. Reverse Vowels of a String #320
 *
 * class Solution {
 *     public String reverseVowels(String s) {
 *
 *         char[] source = s.toCharArray();
 *
 *         Set<Charactor> help = new HashSet<Charactor>();
 *         help.put('a');
 *         help.put('o');
 *         help.put('i');
 *         help.put('u');
 *         help.put('e');
 *
 *         int len = s.length();
 *         if (len == 1) {
 *             return s;
 *         }
 *
 *         int left = 0; int right = len - 1;
 *
 *         while (left < right) {
 *             while (!help.contains(s.charAt(left))) {
 *                 left++;
 *             }
 *
 *             while (!help.contains(s.charAt(right))) {
 *                 right--;
 *             }
 *
 *             if (left < right) {
 *                 char swap = s.charAt(left);
 *                 source[left] = source[right];
 *                 source[right] = swap;
 *             }
 *         }
 *
 *         return new String(source);
 *
 *
 *     }
 * }
 *
 * Time Complexity: O(N)
 * Space Complexity: O(128)
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Vowels of a String.
 * Memory Usage: 39 MB, less than 81.88% of Java online submissions for Reverse Vowels of a String.
 */
class Solution {
    public String reverseVowels(String s) {

        char[] source = s.toCharArray();

        int[] help = new int[128];

        String vowels = "aoiueAOIUE";
        for (int i = 0; i < vowels.length(); i++) {
            help[vowels.charAt(i)]++;
        }

        int len = s.length();
        if (len == 1) {
            return s;
        }

        int left = 0; int right = len - 1;

        while (left < right) {
            while (left < len - 1 && help[source[left]] != 1) {
                left++;
            }

            while (right > 0 && help[source[right]] != 1) {
                right--;
            }

            if (left < right) {
                char swap = s.charAt(left);
                source[left] = source[right];
                source[right] = swap;
            }

            left++;
            right--;
        }

        return new String(source);


    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
