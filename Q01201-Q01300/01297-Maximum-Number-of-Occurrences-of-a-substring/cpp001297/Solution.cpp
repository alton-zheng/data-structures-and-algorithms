// Runtime: 108 ms, faster than 56.02% of C++ online submissions for Maximum Number of Occurrences of a Substring.
// Memory Usage: 10.5 MB, less than 99.72% of C++ online submissions for Maximum Number of Occurrences of a Substring.

// Time Complexity: O(N)
// Space Complexity: O(N)

using LL = long long;

class Solution {
private:
    static constexpr int mod = 1000000007;

public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {

        int sLen = s.size();
        unordered_map<int, int> help;
        unordered_map<char, int> count;
        int res = 0, exist_cnt = 0;
        int rabin = 0, base = 26, base_mul = base;

        for (int i = 0; i < sLen; i++) {
            count[s[i]]++;
            if (count[s[i]] == 1) {
                exist_cnt++;
            }

            rabin = ((LL) rabin * base + (s[i] - 97)) % mod;

            if (i < minSize - 1) {
                base_mul = (LL) base_mul * base % mod;
            }

            if (i >= minSize) {
                count[s[i - minSize]]--;
                if (count[s[i - minSize]] == 0) {
                    exist_cnt--;
                }

                rabin = (rabin - (LL)base_mul * (s[i - minSize] - 97) % mod + mod) % mod;
            }

            if (i >= minSize - 1 && exist_cnt <= maxLetters) {
                help[rabin]++;
                res = max(res, help[rabin]);
            }
        }
        return res;
    }
};