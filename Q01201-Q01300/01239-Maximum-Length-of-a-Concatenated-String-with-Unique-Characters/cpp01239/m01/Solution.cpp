// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Maximum Length of a Concatenated String with Unique Characters.
// Memory Usage: 8 MB, less than 91.48% of C++ online submissions for Maximum Length of a Concatenated String with Unique Characters.
class Solution {
public:
    int maxLength(vector<string>& arr) {

        vector<int> masks;

        for (string& s: arr) {

            int mask = 0;
            for (char c: s) {
                c -= 'a';
                if ((mask >> c) & 1) {
                    mask = 0;
                    break;
                }

                mask |= 1 << c;
            }

            if (mask > 0) {
                masks.push_back(mask);
            }
        }

        int res = 0;
        function<void(int, int)> backtrack =  [&](int pos, int mask) {

            if (pos == masks.size()) {
                res = max(res, __builtin_popcount(mask));
                return;
            }

            if ((masks[pos] & mask) == 0) {
                backtrack(pos + 1, mask | masks[pos]);
            }

            backtrack(pos + 1, mask);

        };

        backtrack(0, 0);
        return res;
    }
};