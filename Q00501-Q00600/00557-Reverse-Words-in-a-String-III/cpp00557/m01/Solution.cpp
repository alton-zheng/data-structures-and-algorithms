// Time Complexity : O(N)
// Space Complexity  O(1)
// Runtime: 16 ms, faster than 76.12% of C++ online submissions for Reverse Words in a String III.
// Memory Usage: 9.6 MB, less than 89.63% of C++ online submissions for Reverse Words in a String III.
class Solution {
public:
    string reverseWords(string s) {

        int length = s.length();

        int i = 0;

        while (i < length) {
            int start = i;
            while (i < length && s[i] != ' ') {
                i++;
            }

            int left = start, right = i - 1;
            while (left < right) {
                swap(s[left], s[right]);
                left++;
                right--;
            }

            while (i < length && s[i] == ' ') {
                i++;
            }

        }
        return s;
    }
};