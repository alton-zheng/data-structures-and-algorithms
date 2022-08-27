package java00000.m2;

/**
 * @Author: alton
 * @Date: Created in 2021/8/1 12:34 下午
 * @Description:
 */
class Solution {
    public int secondsToRemoveOccurrences(String s) {

        int res = 0;
        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().secondsToRemoveOccurrences("0110101"));
    }
}