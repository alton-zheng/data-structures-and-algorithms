// Runtime: 92 ms, faster than 83.44% of C++ online submissions for Maximum Element After Decreasing and Rearranging.
// Memory Usage: 53.2 MB, less than 18.21% of C++ online submissions for Maximum Element After Decreasing and Rearranging.
class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {

        int len = arr.size();
        vector<int> help(len + 1);

        for (int item: arr) {
            help[min(item, len)]++;
        }

        int diff = 0;

        for (int i = 1; i <= len; i++) {
            if (help[i] == 0) {
                diff++;
            } else {
                diff -= min(help[i] - 1, diff);
            }
        }

        return len - diff;
    }
};