// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Check If String Is a Prefix of Array.
// Memory Usage: 14 MB, less than 25.00% of C++ online submissions for Check If String Is a Prefix of Array.
class Solution {
public:
    bool isPrefixString(string s, vector<string>& words) {
        string res;
        for (int i = 0; i < words.size(); i++) {
            res += words[i];
            if (res == s) {
                return true;
            }
        }

        return false;
    }
};