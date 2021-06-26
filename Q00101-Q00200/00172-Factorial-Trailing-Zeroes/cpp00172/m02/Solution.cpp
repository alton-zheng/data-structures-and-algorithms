// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Factorial Trailing Zeroes.
// Memory Usage: 5.9 MB, less than 25.09% of C++ online submissions for Factorial Trailing Zeroes.
// Time Complexity : O(logN)
// Space Complexity : O(1)
class Solution {
public:
    int trailingZeroes(int n) {

        int res = 0;

        int power5 = 5;

        while (n >= power5) {
            res += n / power5;
            power5 *= 5;
        }

        return res;

    }
};