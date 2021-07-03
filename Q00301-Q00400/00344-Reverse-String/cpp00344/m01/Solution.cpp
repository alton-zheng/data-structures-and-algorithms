// Runtime: 20 ms, faster than 77.78% of C++ online submissions for Reverse String.
// Memory Usage: 23.5 MB, less than 38.22% of C++ online submissions for Reverse String.
class Solution {
public:
    void reverseString(vector<char>& s) {
        vector<char> res(s.size());

        int cur = s.size() - 1;
        for (char c: s) {
            res[cur--] = c;
        }

        s = res;
    }
};