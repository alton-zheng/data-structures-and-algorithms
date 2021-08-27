// Runtime: 4 ms, faster than 70.37% of C++ online submissions for Consecutive Characters.
// Memory Usage: 6.8 MB, less than 71.50% of C++ online submissions for Consecutive Characters.
class Solution {
public:
    int maxPower(string s) {

        int res = 1;
        int cnt = 1;
        int pre = s[0];


        for (int i = 1; i < s.size(); i++) {
            if (s[i] == pre) {
                cnt++;
            } else {
                cnt = 1;
                pre = s[i];
            }
            res = max(res, cnt);
        }

        return res;
    }
};