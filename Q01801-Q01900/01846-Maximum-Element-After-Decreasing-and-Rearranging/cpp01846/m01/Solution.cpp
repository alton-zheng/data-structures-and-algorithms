// Runtime: 96 ms, faster than 68.87% of C++ online submissions for Maximum Element After Decreasing and Rearranging.
// Memory Usage: 51.2 MB, less than 95.03% of C++ online submissions for Maximum Element After Decreasing and Rearranging.
class Solution {
public:
    int maximumElementAfterDecrementingAndRearranging(vector<int>& arr) {

        sort(arr.begin(), arr.end());
        int len = arr.size();

        arr[0] = 1;

        for (int i = 1; i < len; i++) {
            arr[i] = min(arr[i - 1] + 1, arr[i]);
        }

        return arr[len - 1];
    }
};