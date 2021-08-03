// Runtime: 36 ms, faster than 80.39% of C++ online submissions for Largest Merge Of Two Strings.
// Memory Usage: 164.1 MB, less than 46.82% of C++ online submissions for Largest Merge Of Two Strings.
class Solution {
public:
    string largestMerge(string word1, string word2) {

        string res;

        int w1Len = word1.size(), w2Len = word2.size();
        int w1Idx = 0, w2Idx = 0, resIdx = 0;

        while (w1Idx < w1Len && w2Idx < w2Len) {

            if (word1[w1Idx] == word2[w2Idx]) {
                if (word1.substr(w1Idx) < word2.substr(w2Idx)) {
                    res.push_back(word2[w2Idx++]);
                } else {
                  res.push_back(word1[w1Idx++]);
                }

                continue;
            }

            if (word1[w1Idx] < word2[w2Idx]) {
                res.push_back(word2[w2Idx++]);
            } else {
                res.push_back(word1[w1Idx++]);
            }
        }

        while (w1Idx < w1Len) {
            res.push_back(word1[w1Idx++]);
        }

        while (w2Idx < w2Len) {
             res.push_back(word2[w2Idx++]);
        }

        return res;
    }

};