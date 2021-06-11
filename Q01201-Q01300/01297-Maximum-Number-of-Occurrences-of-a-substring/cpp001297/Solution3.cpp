// Runtime: 1940 ms, faster than 5.04% of C++ online submissions for Maximum Number of Occurrences of a Substring.
// Memory Usage: 268.2 MB, less than 5.04% of C++ online submissions for Maximum Number of Occurrences of a Substring.

// Time Complexity: O(NS^2)
// Space Complexity: O(NS^2)

class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {

       int sLen = s.size();

       unordered_map<string, int> help;

       int res = 0;

       for (int i = 0; i < sLen; i++) {

            unordered_set<char> temp;
            string cur;
            for (int j = i; j < min(sLen, i + maxSize); j++) {
                temp.insert(s[j]);
                if (temp.size() > maxLetters) {
                    break;
                }

                cur += s[j];
                if (j - i + 1 >= minSize) {
                    help[cur]++;
                    res = max(res, help[cur]);
                }
            }
       }

       return res;
    }
};