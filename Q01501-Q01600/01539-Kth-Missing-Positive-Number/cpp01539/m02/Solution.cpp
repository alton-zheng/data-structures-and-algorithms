// Runtime: 8 ms, faster than 29.62% of C++ online submissions for Kth Missing Positive Number.
// Memory Usage: 9.7 MB, less than 32.27% of C++ online submissions for Kth Missing Positive Number.
class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {

        // 当 k 比首个元素还小时，直接返回 k
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.size() ? arr[mid] : INT_MAX;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k + l;
    }
};