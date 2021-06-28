// Runtime: 16 ms, faster than 75.18% of C++ online submissions for Redistribute Characters to Make All Strings Equal.
// Memory Usage: 11.6 MB, less than 65.85% of C++ online submissions for Redistribute Characters to Make All Strings Equal.
class Solution {
public:
    bool makeEqual(vector<string>& words) {

        vector<int> help(26, 0);
        int len = words.size();
        for (string& word: words) {
            for (char c: word) {
                help[c - 'a']++;
            }
        }

        /*for (int i = 0; i < 26; i++) {
            if (help[i] % len != 0) {
                return false;
            }
        }

        return true;*/

        return all_of(help.begin(), help.end(), [len](int x){return x % n == 0;});
    }
};