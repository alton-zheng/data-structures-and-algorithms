// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Merge Strings Alternately.
// Memory Usage: 6.5 MB, less than 12.27% of C++ online submissions for Merge Strings Alternately.
class Solution {
public:
    string mergeAlternately(string word1, string word2) {

        string res;

        int word1Idx = 0, word2Idx = 0, cur = 0;

        while (word1Idx < word1.size() && word2Idx < word2.size()) {
            res += string() + word1[word1Idx++] + word2[word2Idx++];
        }

       return res + word1.substr(word1Idx) + word2.substr(word2Idx);

    }
};