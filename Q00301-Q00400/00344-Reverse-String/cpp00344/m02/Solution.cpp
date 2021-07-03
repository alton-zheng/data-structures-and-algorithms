// Runtime: 16 ms, faster than 93.91% of C++ online submissions for Reverse String.
// Memory Usage: 23.3 MB, less than 38.22% of C++ online submissions for Reverse String.
class Solution {
public:
    void reverseString(vector<char>& s) {
        int left = 0, right = s.size() - 1;

        while (left < right) {
            swap(s[left++], s[right--]);
        }
    }
};