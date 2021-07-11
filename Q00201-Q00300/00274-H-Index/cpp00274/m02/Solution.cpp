// Runtime: 4 ms, faster than 56.39% of C++ online submissions for H-Index.
// Memory Usage: 8.6 MB, less than 36.03% of C++ online submissions for H-Index.
class Solution {
public:
    int hIndex(vector<int>& citations) {

        int left = 0 , right = citations.size() + 1;

        while (left < right) {

            int mid = left + ((right - left) >> 1);

            int cur = 0;

            for (int c: citations) {
                if (c >= mid) {
                    cur++;
                }
            }

            if (cur < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left - 1;
    }
};