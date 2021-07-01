// Runtime: 4 ms, faster than 88.96% of C++ online submissions for Minimum Changes To Make Alternating Binary String.
// Memory Usage: 6.9 MB, less than 64.17% of C++ online submissions for Minimum Changes To Make Alternating Binary String.
class Solution {
public:
    int minOperations(string s) {
        int zero = 0, one = 0;

        for (int i = 0; i < s.size(); i++) {
            if (i % 2 == s[i] % 2) {
                one++;
            } else {
                zero++;
            }
        }
        return min(zero, one);
    }
};