// Runtime: 4 ms, faster than 88.96% of C++ online submissions for Minimum Changes To Make Alternating Binary String.
// Memory Usage: 6.9 MB, less than 64.17% of C++ online submissions for Minimum Changes To Make Alternating Binary String.
class Solution {
public:
    int minOperations(string s) {
        int zero = 0, one = 0;
        char flag = '1';

        for (int i = 0 ;i < s.size(); i++) {
            if (s[i] == flag) {
                zero++;
            } else {
                one++;
            }
            flag = flag == '0'?'1':'0';
        }

        return min(zero, one);
    }
};