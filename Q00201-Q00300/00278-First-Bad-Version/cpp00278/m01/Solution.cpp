// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for First Bad Version.
// Memory Usage: 5.9 MB, less than 64.44% of C++ online submissions for First Bad Version.

class Solution {
public:
    int firstBadVersion(int n) {
        int left = 1, right = n;

        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};