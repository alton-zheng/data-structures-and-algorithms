// Runtime: 4 ms, faster than 99.03% of C++ online submissions for Valid Anagram.
// Memory Usage: 7.4 MB, less than 37.17% of C++ online submissions for Valid Anagram.
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }

        vector<int> help(26);

        for (int i = 0; i < s.size(); i++) {
            help[s[i] - 'a']++;
            help[t[i] - 'a']--;
        }

        for (int num: help) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
};