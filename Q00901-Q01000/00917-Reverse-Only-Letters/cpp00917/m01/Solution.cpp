// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Reverse Only Letters.
// Memory Usage: 6.2 MB, less than 19.98% of C++ online submissions for Reverse Only Letters.
class Solution {
public:
    string reverseOnlyLetters(string s) {
        string res;
        int len = s.size();
        int j = len - 1;
        for (int i = 0; i < len; i++) {
            if ((s[i] >='a'&&s[i] <='z')||(s[i] >='A'&&s[i] <='Z')) {
                while (!((s[j] >='a'&& s[j] <='z')||(s[j] >='A'&& s[j] <='Z'))) {
                    j--;
                }
                res += s[j--];

            } else {
                res += s[i];
            }
        }

        return res;
    }
};