// Runtime: 1940 ms, faster than 5.04% of C++ online submissions for Maximum Number of Occurrences of a Substring.
// Memory Usage: 268.2 MB, less than 5.04% of C++ online submissions for Maximum Number of Occurrences of a Substring.

// Time Complexity: O(NS)
// Space Complexity: O(NS)

// Runtime: 392 ms, faster than 34.31% of C++ online submissions for Maximum Number of Occurrences of a Substring.
// Memory Usage: 71.1 MB, less than 36.55% of C++ online submissions for Maximum Number of Occurrences of a Substring.

class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {

       int sLen = s.size();

       unordered_map<string, int> help;

       int res = 0;

       for (int i = 0; i < sLen - minSize + 1; i++) {

            string cur = s.substr(i, minSize);
            unordered_set<char> temp(cur.begin(), cur.end());

            if (temp.size() <= maxLetters) {
                help[cur]++;
                res = max(res, help[cur]);
            }
       }

       return res;
    }
};