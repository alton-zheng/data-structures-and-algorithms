// Runtime: 140 ms, faster than 87.84% of C++ online submissions for Palindrome Pairs.
// Memory Usage: 43.5 MB, less than 85.09% of C++ online submissions for Palindrome Pairs.
class Solution {

private:
    vector<string> wordsRev;
    unordered_map<string, int> help;

    int find(const string& word, int left, int right) {
        auto iter = help.find(word.substr(left, right - left + 1));
        return iter == help.end() ? -1 : iter -> second;
    }

    bool isPalindrome(const string& word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (word[left + i] != word[right - i]) {
                return false;
            }
        }

        return true;
    }
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {

        int wordsLen = words.size();
        vector<vector<int>> res;

        for (const string& word: words) {
            wordsRev.push_back(word);
            reverse(wordsRev.back().begin(), wordsRev.back().end());
        }
        for (int i = 0; i < wordsLen; ++i) {
            help.emplace(wordsRev[i], i);
        }


        for (int i = 0; i < wordsLen; i++) {
            int m = words[i].length();

            for (int j = 0; j <= m; j++) {

                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = find(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        res.push_back({i, leftId});
                    }
                }

                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = find(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        res.push_back({rightId, i});
                    }
                }
            }
        }

        return res;
    }
};