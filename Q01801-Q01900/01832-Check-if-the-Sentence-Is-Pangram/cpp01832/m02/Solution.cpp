// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Check if the Sentence Is Pangram.
// Memory Usage: 6.5 MB, less than 63.15% of C++ online submissions for Check if the Sentence Is Pangram.
class Solution {
public:
    bool checkIfPangram(string sentence) {
        if (sentence.size() < 26) {
            return false;
        }

        // 26 字母在一个数字的二进制位上进行模拟
        int res = 0;
        for (char c: sentence) {
            res |= 1 << (c - 'a');
            if ((res ^ 0x3ffffff) == 0) {
                return true;
            }
        }

        return false;
    }
};