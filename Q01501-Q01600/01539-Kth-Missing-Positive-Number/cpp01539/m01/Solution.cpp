// Runtime: 8 ms, faster than 29.62% of C++ online submissions for Kth Missing Positive Number.
// Memory Usage: 9.7 MB, less than 32.27% of C++ online submissions for Kth Missing Positive Number.
class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        for (int item: arr) {
            if (item <= k) {
                k++;
            }
        }

        return k;
    }
};