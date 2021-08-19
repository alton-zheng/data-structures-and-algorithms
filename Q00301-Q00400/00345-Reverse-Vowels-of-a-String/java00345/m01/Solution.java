package java00345.m01;

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
 * Space Complexity: O(1)
 */
class Solution {
    public String reverseVowels(String s) {

        char[] source = s.toCharArray();

        Set<Character> help = new HashSet<>();
        help.add('a');
        help.add('o');
        help.add('i');
        help.add('u');
        help.add('e');
        help.add('A');
        help.add('O');
        help.add('I');
        help.add('U');
        help.add('E');

        int len = s.length();
        if (len == 1) {
            return s;
        }

        int left = 0; int right = len - 1;

        while (left < right) {
            while (left < len - 1 && !help.contains(source[left])) {
                left++;
            }

            while (right > 0 && !help.contains(source[right])) {
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
