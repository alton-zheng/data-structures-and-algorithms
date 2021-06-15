// Runtime: 36 ms, faster than 78.66% of C++ online submissions for Smallest String With A Given Numeric Value.
// Memory Usage: 21.1 MB, less than 76.22% of C++ online submissions for Smallest String With A Given Numeric Value.
class Solution {
public:
    string getSmallestString(int n, int k) {
        string res = string(n, 'a');
        k -= n;

        while (k > 0) {
            res[--n] += min(k, 25);
            k -= min(k, 25);
        }

        return res;

    }
};