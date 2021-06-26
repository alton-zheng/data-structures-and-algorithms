// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Factorial Trailing Zeroes.
// Memory Usage: 5.9 MB, less than 70.91% of C++ online submissions for Factorial Trailing Zeroes.
// Time Complexity : O(logN)
// Space Complexity : O(1)
class Solution {
public:
    int trailingZeroes(int n) {

        int res = 0;

        while (n > 0) {
            n /= 5;
            res += n;
        }

        return res;

    }
};