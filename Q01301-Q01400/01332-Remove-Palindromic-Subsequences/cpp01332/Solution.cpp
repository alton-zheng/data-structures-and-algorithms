// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Remove Palindromic Subsequences.
// Memory Usage: 6.3 MB, less than 7.76% of C++ online submissions for Remove Palindromic Subsequences.
lass Solution {
public:
    int removePalindromeSub(string s) {
        if (s.size() == 0) {
            return 0;
        }

        for (int left = 0, right = s.size() - 1; left <= right; left++, right--) {
            if (s[left] != s[right]) {
                return 2;
            }
        }

        return 1;
    }
};