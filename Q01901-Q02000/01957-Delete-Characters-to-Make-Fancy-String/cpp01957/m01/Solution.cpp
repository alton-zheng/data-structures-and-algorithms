
class Solution {
public:
    string makeFancyString(string s) {
        int len = s.size();

        if (len < 3) {
            return s;
        }

        string res;

        res.push_back(s[0]);
        res.push_back(s[1]);

        for (int i = 2; i < len; i++) {
            if (!(s[i] == s[i - 1] && s[i] == s[i - 2])) {
                res.push_back(s[i]);
            }
        }

        return res;
    }
};