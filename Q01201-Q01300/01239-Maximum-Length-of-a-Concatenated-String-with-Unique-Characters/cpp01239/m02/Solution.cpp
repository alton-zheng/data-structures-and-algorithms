// Runtime: 4 ms, faster than 96.27% of C++ online submissions for Maximum Length of a Concatenated String with Unique Characters.
// Memory Usage: 8.7 MB, less than 76.43% of C++ online submissions for Maximum Length of a Concatenated String with Unique Characters.
class Solution {
public:
    int maxLength(vector<string> &arr) {
        int ans = 0;
        vector<int> masks = {0};
        for (string &s : arr) {
            int mask = 0;
            for (char ch : s) {
                ch -= 'a';
                if ((mask >> ch) & 1) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask == 0) {
                continue;
            }

            for (int i = 0; i < masks.size(); i++){
                if ((masks[i] & mask) == 0) {
                    masks.push_back(masks[i] | mask);
                    ans = max(ans, __builtin_popcount(masks[i] | mask));
                }
            }
        }
        return ans;
    }
};