// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Is Subsequence.
// Memory Usage: 6.4 MB, less than 33.47% of C++ online submissions for Is Subsequence.
class Solution {
public:
    bool isSubsequence(string s, string t) {

        int i = 0, j = 0;

        while (i < s.size() && j < t.size()) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == s.size();
    }
};