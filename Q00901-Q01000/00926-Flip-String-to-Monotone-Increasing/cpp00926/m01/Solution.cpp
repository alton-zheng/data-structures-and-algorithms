// Runtime: 36 ms, faster than 15.63% of C++ online submissions for Flip String to Monotone Increasing.
// Memory Usage: 15.6 MB, less than 13.13% of C++ online submissions for Flip String to Monotone Increasing.
class Solution {
public:
    int minFlipsMonoIncr(string s) {

        int len = s.size();
        vector<int> oneCnt(len + 1, 0);

        for (int i = 1; i <= len; i++) {
            oneCnt[i] = oneCnt[i - 1] + (s[i - 1] == '1' ? 1 : 0);
        }

        int res = 100001;

        for (int i = 0; i <= len; i++) {
            res = min(res, oneCnt[i] + len - i - (oneCnt[len] - oneCnt[i]));
        }

        return res;
    }
};