// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Compare Version Numbers.
// Memory Usage: 6.1 MB, less than 72.95% of C++ online submissions for Compare Version Numbers.
class Solution {
public:
    int compareVersion(string version1, string version2) {

        int v1L = version1.size(), v2L = version2.size();

        int i = 0, j = 0;
        while (i < v1L || j < v2L) {
            int x = 0;
            for (; i < v1L && version1[i] != '.'; i++) {
                x = x * 10 + version1[i] - '0';
            }
            i++;

            int y = 0;
            for (; j < v2L && version2[j] != '.'; j++) {
                y = y * 10 + version2[j] - '0';
            }
            j++;

            if (x != y) {
                return x > y ? 1 : -1;
            }
        }

        return 0;
    }
};