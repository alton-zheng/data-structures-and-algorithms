// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Binary Watch.
// Memory Usage: 6.4 MB, less than 79.66% of C++ online submissions for Binary Watch.
class Solution {
public:
    vector<string> readBinaryWatch(int turnedOn) {

        vector<string> res;

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (__builtin_popcount(h) + __builtin_popcount(m) == turnedOn) {
                    res.push_back(to_string(h) + ":" + (m < 10 ? "0" : "") + to_string(m));
                }
            }
        }

        return res;
    }
};