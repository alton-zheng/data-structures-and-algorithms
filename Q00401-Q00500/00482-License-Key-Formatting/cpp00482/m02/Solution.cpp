// Runtime: 8 ms, faster than 82.68% of C++ online submissions for License Key Formatting.
// Memory Usage: 8.3 MB, less than 40.26% of C++ online submissions for License Key Formatting.
class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        string res = "";

        for (int i = s.size() - 1; i >= 0; i++) {

            // 排除 "-"
            if (s[i] != '-') {

                // e.g. k = 5, res 长度为 4 或 9 时， 满足前面加 "-"
                res += res.size() % (k + 1) == k ? "-" : "";
                // 其余情况，追加 字符（小写 -> 大写）
                res += s[i] > 91 ? (char) (s[i] - 32) : s[i];
            }
        }

        // 反转结果
        reverse(res.begin(), res.end());
        return res;
    }
};