// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Remove Duplicate Letters.
// Memory Usage: 6.7 MB, less than 67.82% of C++ online submissions for Remove Duplicate Letters.
class Solution {
    public:
    string removeDuplicateLetters(string s) {

        vector<int> cnt(26), visit(26);

        for (char c: s) {
            cnt[c - 'a']++;
        }

        string res;
        for (char c: s) {
            if (!visit[c - 'a']) {
                while (res.size() != 0 && res.back() > c) {
                    if (cnt[res.back() - 'a'] > 0) {
                        visit[res.back() - 'a'] = 0;
                        res.pop_back();
                    } else {
                        break;
                    }
                }

                visit[c - 'a'] = 1;
                res.push_back(c);

            }
            cnt[c - 'a']--;
        }

        return res;
    }
};