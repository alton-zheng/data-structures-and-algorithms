// Runtime: 18 ms, faster than 90.99% of C++ online submissions for Maximum Number of Vowels in a Substring of Given Length.
// Memory Usage: 10 MB, less than 24.63% of C++ online submissions for Maximum Number of Vowels in a Substring of Given Length.
class Solution {
public:
    int maxVowels(string s, int k) {

        vector<int> help(26, 0);
        help[0] = help['e' - 'a'] = help['i' - 'a'] = help['o' - 'a'] = help['u' - 'a'] = 1;

        int res = 0;

        for (int i = 0; i <= k - 1; i++) {
            res += help[s[i] - 'a'];
        }

        int idx = 0;
        int pre = res;

        for (int i = k; i < s.size(); i++) {
            pre += help[s[i] - 'a'] - help[s[idx] - 'a'];
            res = max(res, pre);
            idx++;
        }

        return res;
    }
};