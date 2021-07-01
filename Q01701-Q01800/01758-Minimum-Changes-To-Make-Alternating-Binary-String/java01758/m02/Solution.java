package java01758.m02;

// Runtime: 2 ms, faster than 95.12% of Java online submissions for Minimum Changes To Make Alternating Binary String.
// Memory Usage: 39.1 MB, less than 48.64% of Java online submissions for Minimum Changes To Make Alternating Binary String.
class Solution {
    public int minOperations(String s) {
        int zero = 0, one = 0;

        int start = 0;
        for (char c : s.toCharArray()) {
            if (start % 2 == c % 2) {
                one++;
            } else {
                zero++;
            }
            start++;
        }


        return Math.min(zero, one);
    }
}