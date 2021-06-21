// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Binary Watch.
// Memory Usage: 6.5 MB, less than 46.24% of C++ online submissions for Binary Watch.
class Solution {
public:
    vector<string> readBinaryWatch(int turnedOn) {
        vector<string> res;

        for (int i = 0; i < 1026; i++) {
            int h = i >> 6, m = i & 63;

            if (h < 12 && m < 60 && __builtin_popcount(h) + __builtin_popcount(m) == turnedOn) {
                res.push_back(to_string(h) + ":" + (m < 10 ? "0" : "") + to_string(m));
            }
        }

        return res;
    }
};