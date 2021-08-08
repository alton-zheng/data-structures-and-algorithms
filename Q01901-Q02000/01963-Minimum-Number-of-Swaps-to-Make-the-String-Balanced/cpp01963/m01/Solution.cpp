// Runtime: 108 ms, faster than 75.00% of C++ online submissions for Minimum Number of Swaps to Make the String Balanced.
// Memory Usage: 31 MB, less than 25.00% of C++ online submissions for Minimum Number of Swaps to Make the String Balanced.
class Solution {
public:
    int minSwaps(string s) {

        int left = 0, right = 0;

        for (char c: s) {
            if (c == '[') {
                left++;
            }else {

                if (left > 0) {
                    left--;
                } else {
                    right++;
                }

            }
        }

        if (right == 0 || right == 1) {
            return right;
        }

        int half = right >> 1;

        return right == half * 2 ? half : half + 1;
    }
};