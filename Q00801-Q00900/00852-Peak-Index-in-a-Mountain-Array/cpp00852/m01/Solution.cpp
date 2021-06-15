// Runtime: 8 ms, faster than 92.77% of C++ online submissions for Peak Index in a Mountain Array.
// Memory Usage: 11.5 MB, less than 85.71% of C++ online submissions for Peak Index in a Mountain Array.
class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int left = 1, right = arr.length - 1, mid;
        while (true) {
            mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid - 1]) {

                if (arr[mid + 1] > arr[mid]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid;
            }
        }
    }
};