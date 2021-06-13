// Memory Limit Exceeded
class Solution {
public:
    string licenseKeyFormatting(string s, int k) {

        string res = "";

        int count = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] != '-') {
                res = (s[i] > 91 ? (char) (s[i] - 32) : s[i]) + res;
                count++;
            }

            if (count == k) {
                res = '-' + res;
                count = 0;
            }

        }

        if (res.size() == 0) {
            return res;
        }

        return res[0] == '-' ? res.substr(1, res.size() - 1) : res;
    }
};